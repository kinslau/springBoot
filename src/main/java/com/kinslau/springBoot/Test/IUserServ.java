package com.kinslau.springBoot.Test;

import java.util.List;

/**
 * Created by 刘 辉 on 2017/8/3.
 */
public interface IUserServ {

    List<Integer> findAllUser();

    int deleteUserById(Integer id);

    int insertUser();

}
