package com.my.web;

import com.my.auth.RedisTokenManager;
import com.my.auth.Token;
import com.my.auth.UserInfo;
import com.my.service.UserService;
import com.my.web.bean.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zxc on 2019/1/23.
 */
@RestController
public class ResetController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisTokenManager redisTokenManager;

    @RequestMapping(value="/login/{username}/{password}",method = RequestMethod.GET
            ,produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public Object login(@PathVariable String username,@PathVariable String password,
                        HttpServletRequest request){
        Token tokenBean=new Token();
        UserInfo user = this.userService.login(username, password);
        if (user != null) {
        //登录成功生成token并保存token
            String userAgent = request.getHeader("user-agent");
            String token = this.redisTokenManager.getToken(user);
            tokenBean.setIsLogin(true);
        } else {
            tokenBean.setIsLogin(false);
        }
        return tokenBean;
    }

}
