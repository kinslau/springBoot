package com.kinslau.Test.delegate;

/**
 * Created by 刘 辉 on 2017/8/14.
 */
public class AOP {

    public static void main(String[] args){

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        UserService service = new UserServiceImpl();
        MyInvocationHandler handler = new MyInvocationHandler(service);
        UserService proxy = (UserService) handler.getProxy();
        System.out.println(proxy.getClass().getName());
        proxy.add();
    }
}
