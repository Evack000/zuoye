package com.zs.zuoye.entity;

import java.util.List;

public class User {
    private int userId;
    private String userName;
    private String userPwd;
    private String profileName;
    private String userPromission;

    private List<Role> roles;

    private List<Course> courses;

    public User(){

    }

    public User(int userId, String userName, String userPwd, String profileName, String userPromission) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.profileName = profileName;
        this.userPromission = userPromission;
    }

    public User(int userId, String userName, String userPwd, String profileName, String userPromission, List<Role> roles) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.profileName = profileName;
        this.userPromission = userPromission;
        this.roles = roles;
    }

    public User(int userId, String userName, String userPwd, String profileName, String userPromission, List<Role> roles, List<Course> courses) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.profileName = profileName;
        this.userPromission = userPromission;
        this.roles = roles;
        this.courses = courses;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getUserPromission() {
        return userPromission;
    }

    public void setUserPromission(String userPromission) {
        this.userPromission = userPromission;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
