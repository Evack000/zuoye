package com.zs.zuoye.relations;

public class courseregistration {

    private int userId;
    private int courseId;

    public courseregistration(){}

    public courseregistration(int userid, int courseId) {
        this.userId = userid;
        this.courseId = courseId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
