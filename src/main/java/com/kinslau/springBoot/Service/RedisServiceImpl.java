package com.kinslau.springBoot.Service;

import com.kinslau.springBoot.Entity.User;
import org.springframework.stereotype.Service;

/**
 * Created by 刘 辉 on 2017/8/11.
 */

@Service
public class RedisServiceImpl extends RedisService<User> {
    private static final String REDIS_KEY = "test";


    @Override
     public String getRedisKey() {
        return this.REDIS_KEY;
    }
}
