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


     public abstract String getRedisKey(String redisKey);


    public void put(String redisKey,String field,T domain,long expire){

        hashOperations.put(redisKey,field,domain);
        if (expire != -1){
            redisTemplate.expire(redisKey,expire,TimeUnit.SECONDS.SECONDS);
        }
    }

    public void remove(String redisKey,String field){
        hashOperations.delete(redisKey,field);
    }


    public T get(String redisKey,String field){
        return hashOperations.get(redisKey,field);
    }

    public List<T> getAll(String redisKey){
        return hashOperations.values(redisKey);
    }

    public boolean isKeyExists(String redisKey,String field){
        return hashOperations.hasKey(redisKey,field);
    }

    public long count(String redisKey){
        return hashOperations.size(redisKey);
    }

    public void empty(String redisKey){
        Set<String> set = hashOperations.keys(redisKey);
        set.stream().forEach(field -> hashOperations.delete(redisKey,field));
    }


    public Set<String> getKeys(String redisKey) {
        return hashOperations.keys(redisKey);
    }
}
