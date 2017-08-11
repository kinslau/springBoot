package com.kinslau.springBoot.Test.thread;

/**
 * Created by 刘 辉 on 2017/8/9.
 */
public class ThreadA extends Thread{

    Signal signal;
    ThreadB threadB;

    public ThreadA(Signal signal,ThreadB threadB){
        this.signal = signal;
        this.threadB = threadB;
    }


    @Override
    public void run() {
        while (true){
            System.out.println("线程B的计算结果是："+threadB.count+"____________");
            if (signal.hasDataToProcess()){
                System.out.println("线程B的计算结果是："+threadB.count);
                break;
            }
        }
    }


    public static void main(String[] args){
        Signal signal = new Signal();
        ThreadB threadB = new ThreadB(signal);
        ThreadA threadA = new ThreadA(signal,threadB);

        threadB.start();
        threadA.start();
    }
}
