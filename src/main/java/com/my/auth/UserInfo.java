package com.my.auth;

/**
 * Created by zxc on 2019/1/25.
 */
public class UserInfo {
    private String userId;
    private String userName;
    private String password;

    public UserInfo(String userId,String userName,String password)
    {
        this.userName=userName;
        this.password=password;
        this.userId=userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
