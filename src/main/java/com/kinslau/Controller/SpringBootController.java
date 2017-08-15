package com.kinslau.Controller;

import com.kinslau.Entity.User;
import com.kinslau.Service.RedisServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by 刘 辉 on 2017/7/31.
 */

@Controller

public class SpringBootController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;


    @Autowired
    RedisServiceImpl redisService;


    @ApiOperation(value="redis测试")
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    @ResponseBody
    public String test3(@RequestParam String redisKey)  {

        User user1 = new User("刘辉",23,"user1");
        redisService.put(redisKey,user1.getFiled(),user1,-1);
        User user2 = new User("李斌",24,"user2");
        redisService.put(redisKey,user2.getFiled(),user2,-1);
        User user3 = new User("江力",22,"user3");
        redisService.put(redisKey,user3.getFiled(),user3,-1);

        return  "add success end ...";
    }


    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public Object getAll(@RequestParam(required =  false) String redisKey) {
        Object o =  redisService.getAll(redisKey);
        return o;
    }


    @RequestMapping(value = "/getKeys", method = RequestMethod.GET)
    @ResponseBody
    public Object getKeys(@RequestParam(required =  false) String redisKey) {
        return redisService.getKeys(redisKey);
    }



    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public Object get(@RequestParam(required =  false) String redisKey,@RequestParam(required =  false) String field) {

        Object o = redisService.get(redisKey,field);
        try {
            Method method = Class.forName("com.kinslau.Entity.User").getMethod("getFiled",new Class[0]);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return o;
    }


}
