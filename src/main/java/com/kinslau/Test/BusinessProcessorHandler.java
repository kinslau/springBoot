package com.kinslau.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by 刘 辉 on 2017/8/4.
 */
public class BusinessProcessorHandler  implements InvocationHandler{

    private Object target = null;


    BusinessProcessorHandler(Object target){
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("you can do something here before precess your business");
        Object result = method.invoke(target,args);
        System.out.println("you can something here after process your business");
        return result;
    }
}
