package com.zs.zuoye.config;

import com.zs.zuoye.entity.LoginToken;
import com.zs.zuoye.entity.Role;
import com.zs.zuoye.entity.User;
import com.zs.zuoye.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder pEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.getUserInfo(username);
        if(user == null){
            throw new UsernameNotFoundException("用户不存在");
        }

        //User中需要传入最后一个参数authorities
        List<GrantedAuthority> authorities =new ArrayList<GrantedAuthority>();
        for(Role role:user.getRoles()){
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
        }

        LoginToken loginToken = new LoginToken(user.getUserName(),pEncoder.encode(user.getUserPwd()),authorities);
        loginToken.setId(user.getUserId());
        loginToken.setPwd(user.getUserPwd());

        return loginToken;
    }



}
