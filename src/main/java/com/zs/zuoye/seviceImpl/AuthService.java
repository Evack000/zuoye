package com.zs.zuoye.seviceImpl;

import com.zs.zuoye.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

@Service
public class AuthService {

    @Autowired
    private PermissionService permissionService;

    public boolean canAccess(HttpServletRequest request, Authentication authentication){
        boolean flag = false;

        /**
         *  1/未登录的情况下，需要做一个判断或者拦截
         *  anonymousUser(表示未登录)
         *  userDetails.user 表示有用户
         */
        Object principal = authentication.getPrincipal();
        if(principal == null || "anonymousUser".equals(principal)){
            return flag;
        }

        /**
         * 2、 匿名的角色 ROLE_ANONOYMOUS
         */
        if(authentication instanceof AnonymousAuthenticationToken){
            //匿名角色，无需求，先不做处理
            //check
            //return
        }

        /**
         * 3/ 通过request对象url  获取权限信息
         */
        Map<String, Collection<ConfigAttribute>> map =permissionService.getPermissionMap();

        //AntPathRequestMatcher  使用这个的方法不仅可以匹配 /hello/user 还适用/hello/**
        Collection<ConfigAttribute> configAttributes = null;
        for(Iterator<String> it = map.keySet().iterator();it.hasNext();){
            String curUrl = it.next();
            System.out.println("request:"+request);
            AntPathRequestMatcher matcher = new AntPathRequestMatcher(curUrl);
            if(matcher.matches(request)){
                configAttributes = map.get(curUrl);
                break;
            }
        }
        if(configAttributes == null || configAttributes.size()==0){
            return flag;
        }
        /**
         *  4/将获取到的权限信息和当前的登录帐号的权限信息进行比对
         */
        for(Iterator<ConfigAttribute> it = configAttributes.iterator(); it.hasNext();){
            ConfigAttribute cfa = it.next();
            //ROLE_admin  ||  ROLE_normal
            String role = cfa.getAttribute();

            for(GrantedAuthority authority:authentication.getAuthorities()){
                System.out.println("xxxxxxxxxxxxxxx"+authority.getAuthority());
                if(role.equals(authority.getAuthority())){
                    flag=true;
                    break;
                }
            }
        }
        System.out.println("当前匹配到的角色是" + flag);
        return flag;
    }
}
