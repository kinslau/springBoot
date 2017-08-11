package com.kinslau.springBoot.Test.thread;

/**
 * Created by 刘 辉 on 2017/8/9.
 */
public class Signal {

    private boolean hasDataToProcess;

    public synchronized void setHasDataToProcess(boolean hasData){
        this.hasDataToProcess = hasData;
    }
    public synchronized boolean hasDataToProcess(){
        return this.hasDataToProcess;
    }
}
