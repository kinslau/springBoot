package com.kinslau.springBoot.Test;

import java.util.List;

/**
 * Created by 刘 辉 on 2017/8/3.
 */
public class UserServImpl implements IUserServ {

    @Override
    public List<Integer> findAllUser() {
        System.out.println("执行查询方法");
        return null;
    }

    @Override
    public int deleteUserById(Integer id) {
        System.out.println("执行删除方法");
        return 0;
    }

    @Override
    public int insertUser() {
        System.out.println("执行插入方法");
        return 0;
    }
}
