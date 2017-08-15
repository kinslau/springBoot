package com.kinslau.Service;

import com.kinslau.Entity.User;
import org.springframework.stereotype.Service;

/**
 * Created by 刘 辉 on 2017/8/11.
 */

@Service
public class RedisServiceImpl extends RedisService<Object> {


    @Override
    public String getRedisKey(String redisKey) {
        return redisKey;
    }
}
