package com.kinslau.springBoot.Test;

import java.lang.reflect.Proxy;

/**
 * Created by 刘 辉 on 2017/8/3.
 */
public class Test {

    public static void main(String[] args){

//
//        IUserServ iUserServ = new UserServProxyImpl(new UserServImpl());
//        iUserServ.insertUser();


//        LogHandler handler = new LogHandler();
//        IUserServ iUserServ1 = (IUserServ) handler.createProxy(new UserServImpl());
//        iUserServ1.findAllUser();



        BusinessProcessorImpl impl =  new BusinessProcessorImpl();
        BusinessProcessorHandler handler = new BusinessProcessorHandler(impl);
        BusinessProcessor bp = (BusinessProcessor) Proxy.newProxyInstance(impl.getClass().getClassLoader(),impl.getClass().getInterfaces(),handler);
        bp.processBusiness();
        System.out.println(bp.getClass().getName());
    }





}
