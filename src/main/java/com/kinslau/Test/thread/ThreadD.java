package com.kinslau.Test.thread;

/**
 * Created by 刘 辉 on 2017/8/9.
 */
public class ThreadD extends Thread {

    int count;
    MonitorObject signal;

    public ThreadD(MonitorObject signal){
        this.signal = signal;
    }


    @Override
    public void run() {
        for(int i=0;i<100;i++){
            count=count+1;
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        synchronized (signal){
            System.out.println("线程D得到锁");
            signal.notifyAll();
            System.out.println("线程D放弃锁");
        }
    }
}
