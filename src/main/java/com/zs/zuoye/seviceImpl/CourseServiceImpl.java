package com.zs.zuoye.seviceImpl;

import com.zs.zuoye.dao.CourseDao;
import com.zs.zuoye.entity.Course;
import com.zs.zuoye.entityQuery.CoursePageEntityQuery;
import com.zs.zuoye.entityQuery.QueryResult;
import com.zs.zuoye.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public QueryResult<Course> result(CoursePageEntityQuery query) {
        int count = courseDao.selectCount(query);
        List<Course> list = courseDao.findAll(query);
        QueryResult<Course> result =new QueryResult<Course>();
        result.setData(list);
        result.setCount(count);
        result.setPageSize(query.getPerPage());
        result.setPageNumber((query.getStartPer()/query.getPerPage()) + 1);
        return result;
    }
}
