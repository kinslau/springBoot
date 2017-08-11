package com.kinslau.Test;

/**
 * Created by 刘 辉 on 2017/8/4.
 */
public class Tiger implements Animal {

    @Override
    public void eat() {
        System.out.println("Tiger.eat()");
    }

    @Override
    public String toString() {
        return "I am a tiger";
    }
}
