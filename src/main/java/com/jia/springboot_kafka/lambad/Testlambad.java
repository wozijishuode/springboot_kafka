package com.jia.springboot_kafka.lambad;

public class Testlambad {




    private static void show1(MyInterface myInterface) {

        myInterface.getmessage();
    }


    public static void main(String[] args) {
        // 1.作为参数，需要传递实体类
        MyInterface my = new MyImpl();
        show1(my);

        show1(new MyInterface() {
            @Override
            public void getmessage() {
                //自定义内容
                System.out.println("这是围殴自定义的内容");
            }
        });

         //lambad 表达时
        show1(()->{
            System.out.println("这是自定义的内容");
        });
    }
}
