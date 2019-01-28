package com.my.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.my.redis.RedisUtils;
import java.util.UUID;

/**
 * Created by zxc on 2019/1/25.
 */
@Service("redisTokenManager")
public class RedisTokenManager implements TokenManager {
    @Value("${spring.redis.expire}")
    private Integer expire;
    @Autowired
    private RedisUtils redisUtils;

    /**
     * 创建token
     * @param userInfo
     * @return
     */
    public String getToken(UserInfo userInfo){
        //使用uuid作为源token
        String token = UUID.randomUUID().toString().replace("-", "");
        redisUtils.set(token,userInfo,expire);
        return token;
    }

    /**
     * 刷新用户
     * @param token
     */
    public void refreshUserToken(String token){
        Object userInfo=redisUtils.get(token);
        if(userInfo!=null){
            redisUtils.set(token,userInfo,expire);
        }
    }

    /**
     * 用户退出登陆
     * @param token
     */
    public void loginOff(String token){
        redisUtils.del(token);
    }

    /**
     * 获取用户信息
     * @param token
     * @return
     */
    public UserInfo getUserInfoByToken(String token){
        Object userInfo=redisUtils.get(token);
        if(userInfo!=null){
            return (UserInfo)userInfo;
        }
        return null;
    }
}