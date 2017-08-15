package com.kinslau.Test.delegate;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by 刘 辉 on 2017/8/14.
 */
public class MyInvocationHandler implements InvocationHandler{

    private Object target;

    public MyInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("开始： "+method.getName()+" 方法");
        Object object = method.invoke(target,args);
        System.out.println("结束： "+method.getName()+" 方法");

        return object;
    }

    public Object getProxy(){

        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),target.getClass().getInterfaces(),this);
    }
}
