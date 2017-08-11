package com.kinslau.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisUtils;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;



/**
 * Created by 刘 辉 on 2017/7/31.
 */
@Configuration
public abstract class RedisService<T> {


    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @Resource
    HashOperations<String,String,T>  hashOperations;


    abstract String getRedisKey();


    public void put(String key,T domain,long expire){

        hashOperations.put(getRedisKey(),key,domain);
        if (expire != -1){
            redisTemplate.expire(getRedisKey(),expire,TimeUnit.SECONDS.SECONDS);
        }
    }

    public void remove(String key){
        hashOperations.delete(getRedisKey(),key);
    }


    public T get(String key){
        return hashOperations.get(getRedisKey(),key);
    }

    public List<T> getAll(){
        return hashOperations.values(getRedisKey());
    }

    public boolean isKeyExists(String key){
        return hashOperations.hasKey(getRedisKey(),key);
    }

    public long count(){
        return hashOperations.size(getRedisKey());
    }

    public void empty(){
        Set<String> set = hashOperations.keys(getRedisKey());
        set.stream().forEach(key -> hashOperations.delete(getRedisKey(),key));
    }
}
