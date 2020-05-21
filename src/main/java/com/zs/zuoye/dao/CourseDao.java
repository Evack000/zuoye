package com.zs.zuoye.dao;

import com.zs.zuoye.entity.Course;
import com.zs.zuoye.entityQuery.CoursePageEntityQuery;

import java.util.List;

public interface CourseDao {

    public int selectCount(CoursePageEntityQuery query);

    public List<Course> findAll(CoursePageEntityQuery query);
}
