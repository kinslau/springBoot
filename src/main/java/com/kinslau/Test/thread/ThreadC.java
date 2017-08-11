package com.kinslau.Test.thread;

import java.util.Date;

/**
 * Created by 刘 辉 on 2017/8/9.
 */
public class ThreadC extends Thread {

    MonitorObject signal;
    ThreadD threadD;


    public ThreadC(MonitorObject signal,ThreadD threadD){
        this.signal =signal;
        this.threadD = threadD;
    }


    @Override
    public void run() {
        synchronized (signal){
            System.out.println("线程C得到锁");
            try {
                System.err.println(new Date());
                System.out.println("线程C放弃锁");
                signal.wait();
                System.out.println("线程C再次得到锁");
                System.out.println(new Date());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("线程D计算结果为:"+threadD.count);
        }

    }
    public static void main(String[] args){
        MonitorObject signal = new MonitorObject();
        ThreadD threadD = new ThreadD(signal);
        ThreadC threadC = new ThreadC(signal,threadD);

        threadC.start();
        threadD.start();
    }


}
