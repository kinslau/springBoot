package com.kinslau.springBoot.Entity;

import org.springframework.data.annotation.Id;

import javax.annotation.Generated;
import java.io.Serializable;

/**
 * Created by 刘 辉 on 2017/8/2.
 */
public class User implements Serializable {

    private static final long serialVersionUID = -1L;
    private String userName;


    public String getRedisKey() {
        return redisKey;
    }

    public void setRedisKey(String redisKey) {
        this.redisKey = redisKey;
    }

    private String redisKey;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private Integer age;



    public  User(String userName,Integer age,String redisKey){
        this.userName = userName;
        this.age = age;
        this.redisKey = redisKey;
    }


    @Override
    public String toString() {
        return "User Redis key:"+redisKey+" userName: "+userName + " age: "+age;
    }
}
