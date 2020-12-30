package com.jia.springboot_kafka.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component

public class KafkaConsumer {



    @KafkaListener(topics = "testTopic",groupId = "local")
    public void topic_test(ConsumerRecord<String, Object> record, Acknowledgment ack, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {

        Optional message = Optional.ofNullable(record.value());
        try {
            if (message.isPresent()) {
                Object msg = message.get();
                System.out.println(msg);

                JSONObject jsonObject = (JSONObject)JSONObject.toJSON(msg);
                System.out.println( jsonObject);

                ack.acknowledge();
            }
        }catch (Exception e ){
            e.printStackTrace();
        }finally {
            ack.acknowledge();
        }

    }

}
