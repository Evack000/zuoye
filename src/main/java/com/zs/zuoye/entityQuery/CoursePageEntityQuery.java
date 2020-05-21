package com.zs.zuoye.entityQuery;

public class CoursePageEntityQuery extends  PageEntityQuery{

    private String courseName;

    public CoursePageEntityQuery(){}

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
