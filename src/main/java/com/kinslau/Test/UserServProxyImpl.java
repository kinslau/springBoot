package com.kinslau.Test;

import java.util.List;

/**
 * Created by 刘 辉 on 2017/8/3.
 */
public class UserServProxyImpl implements IUserServ {



    private IUserServ iUserServ;


    public UserServProxyImpl(IUserServ iUserServ){
       this.iUserServ = iUserServ;
    }


    public List<Integer> findAllUser() {
        beforeLog();
        iUserServ.findAllUser();
        afterLog();
        return null;
    }

    public int deleteUserById(Integer id) {
        beforeLog();
        iUserServ.deleteUserById(id);
        afterLog();
        return 0;
    }

    public int insertUser() {
        beforeLog();
        iUserServ.insertUser();
        afterLog();
        return 0;
    }


    private void beforeLog(){
        System.out.println("执行之前");
    }

    private void afterLog(){
        System.out.println("执行完毕");
    }
}
