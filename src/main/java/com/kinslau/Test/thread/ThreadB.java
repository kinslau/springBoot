package com.kinslau.Test.thread;

/**
 * Created by 刘 辉 on 2017/8/9.
 */
public class ThreadB extends Thread {
    int count = 100;
    Signal signal;

    public ThreadB(Signal signal){
        this.signal = signal;
    }


    @Override
    public void run() {

        try {
            for (int i =0;i<1000;i++){
                Thread.sleep(10);
                count = count + 1;
                if (count == 1050){
                    Thread.sleep(10);
                }
            }

        }catch (InterruptedException e){
            e.printStackTrace();
        }
        signal.setHasDataToProcess(true);
    }
}
