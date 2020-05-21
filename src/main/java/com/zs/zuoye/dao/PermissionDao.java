package com.zs.zuoye.dao;


import com.zs.zuoye.entity.Permission;

import java.util.List;

public interface PermissionDao {

    public List<Permission> findAll();

    public Permission getPermission(String name);

    public Permission findById(int id);

    public void deletePermissionById(int id);

    public void addPermission(Permission permission);

    public void updatePermission(Permission permission);
}
