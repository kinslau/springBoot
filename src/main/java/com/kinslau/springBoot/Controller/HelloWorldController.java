package com.kinslau.springBoot.Controller;

import com.kinslau.springBoot.Entity.User;
import com.kinslau.springBoot.Service.RedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘 辉 on 2017/7/31.
 */

@RestController

public class HelloWorldController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;


    @Autowired
    RedisServiceImpl redisService;

    @RequestMapping("/hello")
    public String index(){

        List list = new ArrayList();
        list.add(1);
        method(list);
        System.out.println(list);
        return "hello world";
    }

    @RequestMapping("/hello2")
    public String index2(){

        List list = new ArrayList();
        list.add(1);
        method(list);
        return "hello  world";
    }

    @RequestMapping("/hello3")
    public String index3(){
        User user = new User("liu",23,"asd");
        stringRedisTemplate.opsForValue().set(user.getUserName(),"23");

        redisTemplate.opsForValue().set("li",user);

        Object user1 = (Object) redisTemplate.opsForValue().get("li");
        System.out.println(user1);

        if (user1 instanceof User){
            User user2 =  (User)user1;
            System.out.println(user2);
        }else {
            System.out.println("不是user类型");
            System.out.println(user1.getClass());

        }

        stringRedisTemplate.opsForValue().set("kinslau","我是谁");
        System.out.println(stringRedisTemplate.opsForValue().get("kinslau"));

        Object o = stringRedisTemplate.opsForValue().get("liu");
        System.out.println(o);


        if ("23".equals( stringRedisTemplate.opsForValue().get("liu"))){
            return "是的";
        }else {
            return "不是";
        }

    }

    private void  method(List list){

        List newList = new ArrayList();
        newList.add(1);
        newList.add(2);
        newList.add(3);

        System.out.println(newList);
        list = newList;
        System.out.println(list);
    }




    @RequestMapping(value = "/add",method = RequestMethod.GET)
    @ResponseBody
    public String test3(){
        System.out.println("start...");
        User user1 = new User("刘辉",23,"user1");
        redisService.put(redisService.getRedisKey(),user1,-1);
        User user2 = new User("李斌",24,"user2");
        redisService.put(redisService.getRedisKey(),user2,-1);
        User user3 = new User("江力",22,"user3");
        redisService.put(redisService.getRedisKey(),user3,-1);

        System.out.println("add success end ...");
        return  "add success end ...";
    }


    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public Object getAll() {
        return redisService.getAll();
    }





}
