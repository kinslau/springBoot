package com.kinslau.Entity;

import java.io.Serializable;

/**
 * Created by 刘 辉 on 2017/8/14.
 */
public class Recourse implements Serializable {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String address;




}
