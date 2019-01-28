package com.my.service;

import com.my.auth.UserInfo;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {

    public UserInfo login(String username, String password){
        if ("test".equals(username) && "123456".equals(password)){
            return new UserInfo("1", "test", "123456");
        } else {
            return null;
        }
    }

}
