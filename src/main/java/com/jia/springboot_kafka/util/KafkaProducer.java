package com.jia.springboot_kafka.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<Object, Object> kafkaTemplate;


    public  String sendMessage(Object o){

        //发送消息
        ListenableFuture<SendResult<Object, Object>> future = kafkaTemplate.send("testTopic", o);
     /*   future.addCallback(new ListenableFutureCallback<SendResult<Object, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("发送失败");
            }

            @Override
            public void onSuccess(SendResult<Object, Object> stringObjectSendResult) {
                //成功的处理
                System.out.println("发送成功");
            }
        });*/
        return "ok";

    }
}
