package com.zs.zuoye.entityQuery;

public class UserInfoPageEntityQuery extends  PageEntityQuery{

    private int userId;

    public UserInfoPageEntityQuery(){}

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserInfoPageEntityQuery{" +
                "userId=" + userId +
                '}';
    }
}
