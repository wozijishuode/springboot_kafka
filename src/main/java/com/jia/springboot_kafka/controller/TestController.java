package com.jia.springboot_kafka.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jia.springboot_kafka.bean.Animal;
import com.jia.springboot_kafka.bean.Student;
import com.jia.springboot_kafka.util.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/send")
public class TestController {


    @Autowired
    private KafkaProducer kafkaProducer;

    @RequestMapping("Objdata")
    public  String  sendata(){

        Animal dog = new Animal("狗", "1");
        Animal mao = new Animal("mao", "1");
        ArrayList<Animal> animals = new ArrayList<>();
        Student zhangsan = new Student("3", "zhangsan",animals);

        animals.add(dog);
        animals.add(mao);
        List<Animal> pents = zhangsan.getPents();
        JSONObject jsonObject = (JSONObject)JSONObject.toJSON(zhangsan);
        String s = kafkaProducer.sendMessage(jsonObject);

        return s;
    }


    @RequestMapping("Strdata")
    public  String  senStrdata(){

        Animal dog = new Animal("狗", "1");
        Animal mao = new Animal("mao", "1");
        ArrayList<Animal> animals = new ArrayList<>();
        Student zhangsan = new Student("3", "zhangsan",animals);

        animals.add(dog);
        animals.add(mao);
        zhangsan.getPents().addAll(animals);
        String s1 = JSON.toJSONString(zhangsan);
        System.out.println(s1);
        String s = kafkaProducer.sendMessage(s1);

        return s;
    }

}
