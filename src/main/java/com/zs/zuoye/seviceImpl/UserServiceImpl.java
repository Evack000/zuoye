package com.zs.zuoye.seviceImpl;

import com.zs.zuoye.dao.UserDao;
import com.zs.zuoye.entity.User;
import com.zs.zuoye.entityQuery.QueryResult;
import com.zs.zuoye.entityQuery.UserInfoPageEntityQuery;
import com.zs.zuoye.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User getUserInfo(String username){
        return userDao.getUserByName(username);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public QueryResult<User> result(UserInfoPageEntityQuery query){
        int count = userDao.selectCount(query);
        List<User> list = userDao.findAll(query);
        List<User> temp  = new ArrayList<User>();
        for(int i=0;i<list.size();i++){
            if(userDao.getUserCourse(list.get(i).getUserId()) == null){
                temp.add(list.get(i));
            }else {
                temp.add(userDao.getUserCourse(list.get(i).getUserId()));
            }
        }

        QueryResult<User> result =new QueryResult<User>();
        result.setData(temp);
        result.setCount(count);
        result.setPageSize(query.getPerPage());
        result.setPageNumber((query.getStartPer()/query.getPerPage()) + 1);
        return result;
    }


}
