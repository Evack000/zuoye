package com.zs.zuoye.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class LoginToken extends User {
    public LoginToken(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public boolean hasRole(String rolename){
        SimpleGrantedAuthority authority=new SimpleGrantedAuthority("ROLE_"+rolename);
        return getAuthorities().contains(authority);
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    private int id;
    private String pwd;
}