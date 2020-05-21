package com.zs.zuoye.entity;

import java.util.List;

public class Permission {

    private int id;
    private String name;
    private String description;
    private String url;
    private int fid;  //父ID
    //角色和权限关系——多对多
    private List<Role> roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "permission [" +
                "pid=" + this.id +
                ", pname=" + this.name +
                ", url=" + this.url +
                ",roles "+ roles +
                "]";
    }


}
