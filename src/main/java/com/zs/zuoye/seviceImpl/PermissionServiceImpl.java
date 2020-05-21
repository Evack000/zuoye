package com.zs.zuoye.seviceImpl;

import com.zs.zuoye.dao.PermissionDao;
import com.zs.zuoye.entity.Permission;
import com.zs.zuoye.entity.Role;
import com.zs.zuoye.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    //key 是 url  ，value 是 权限集合
    private Map<String, Collection<ConfigAttribute>> permissionMap = null;

    @Override
    public Map<String, Collection<ConfigAttribute>> getPermissionMap() {
        if(permissionMap == null || permissionMap.size() ==0 ){
            initPermissions();
        }
        return permissionMap;
    }

    //一加载项目  就加载权限信息
    @PostConstruct
    public void initPermissions(){
        //从数据库中获取权限信息，遍历后，存储到permissionMap中
        permissionMap = new HashMap<>();
        List<Permission> permissions = permissionDao.findAll();

        for (Permission p : permissions){
            Collection<ConfigAttribute> collection = new ArrayList<ConfigAttribute>();
            for(Role role:p.getRoles()){
                ConfigAttribute configAttribute = new SecurityConfig("ROLE_"+role.getName());
                collection.add(configAttribute);
            }
            permissionMap.put(p.getUrl(),collection);
            System.out.println(permissionMap);
        }

    }



}
