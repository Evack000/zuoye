package com.zs.zuoye.dao;

import com.zs.zuoye.entity.User;
import com.zs.zuoye.entityQuery.UserInfoPageEntityQuery;

import java.util.List;

public interface UserDao {

    public User getUser(int id);

    public User getUserByName(String username);

    public User getUserCourse(int id);

    public void updateUser(User user);

    public int selectCount(UserInfoPageEntityQuery query);

    public List<User> findAll(UserInfoPageEntityQuery query);



}
