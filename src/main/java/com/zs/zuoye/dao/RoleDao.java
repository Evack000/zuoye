package com.zs.zuoye.dao;


import com.zs.zuoye.entity.Role;

import java.util.List;

public interface RoleDao {

    public Role getRole(String name);

    public Role findById(int id);

    public List<Role> findAll();

    public void deleteRoleById(int id);

    public void addRole(Role role);

    public void updateRole(Role role);


}
