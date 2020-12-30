package com.jia.springboot_kafka.lambad;

public class MyImpl implements MyInterface {
    @Override
    public void getmessage() {
        System.out.println("这是myImpl");
    }
}
