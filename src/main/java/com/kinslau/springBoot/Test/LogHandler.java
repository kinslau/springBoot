package com.kinslau.springBoot.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by 刘 辉 on 2017/8/3.
 */
public class LogHandler implements InvocationHandler{

    private Object targetObject;
    public Object createProxy(Object targetObject){
        this.targetObject = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),targetObject.getClass().getInterfaces(), this);


    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj = null;
        try {
            beforeLog();
            obj = method.invoke(targetObject,args);
            afterLog();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private void beforeLog(){
        System.out.println("开始执行");
    }

    private void afterLog(){
        System.out.println("执行完毕");
    }

}
