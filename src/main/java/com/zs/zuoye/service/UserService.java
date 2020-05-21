package com.zs.zuoye.service;

import com.zs.zuoye.entity.User;
import com.zs.zuoye.entityQuery.QueryResult;
import com.zs.zuoye.entityQuery.UserInfoPageEntityQuery;

public interface UserService {

    public User getUserInfo(String username);

    public void updateUser(User user);

    public QueryResult<User> result(UserInfoPageEntityQuery query);


}
