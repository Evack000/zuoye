package com.zs.zuoye.entity;

public class PwdInfo {
    public String oldpwd;
    public String newpwd;

    public String getOldpwd() {
        return oldpwd;
    }

    public void setOldpwd(String oldpwd) {
        this.oldpwd = oldpwd;
    }

    public String getNewpwd() {
        return newpwd;
    }

    public void setNewpwd(String newpwd) {
        this.newpwd = newpwd;
    }

    public PwdInfo(String oldpwd, String newpwd) {   
        this.oldpwd = oldpwd;
        this.newpwd = newpwd;
    }

    public PwdInfo(){}


}
