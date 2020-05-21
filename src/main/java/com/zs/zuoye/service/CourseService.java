package com.zs.zuoye.service;

import com.zs.zuoye.entity.Course;
import com.zs.zuoye.entityQuery.CoursePageEntityQuery;
import com.zs.zuoye.entityQuery.QueryResult;

public interface CourseService {

    public QueryResult<Course> result(CoursePageEntityQuery query);

}
