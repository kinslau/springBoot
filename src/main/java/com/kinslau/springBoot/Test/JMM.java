package com.kinslau.springBoot.Test;

/**
 * Created by 刘 辉 on 2017/8/10.
 */
public class JMM {

    public int getI() {


        return i;
    }

    public void setI(int i) {

        i = 5;
    }

    public Integer getJ() {

        return j;
    }

    public void setJ(Integer j) {
      j = 30;

    }

    int i = 10;
    Integer j = 20;




    public static void main(String[] args){

        JMM jmm = new JMM();
        jmm.setI(jmm.i);
        jmm.getI();
        jmm.setJ(jmm.j);
        jmm.getJ();
        System.out.println(jmm.i);
        System.out.println(jmm.j);


    }





}
