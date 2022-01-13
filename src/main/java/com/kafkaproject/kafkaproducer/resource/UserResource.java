package com.kafkaproject.kafkaproducer.resource;

import com.kafkaproject.kafkaproducer.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class UserResource {

    @Autowired
    private KafkaTemplate<String , Employee> kafkaTemplate;
    private static final String TOPIC="demoTopic";

    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name")final String name){


        kafkaTemplate.send(TOPIC,new Employee(name,"Engineering",200000L));
        return "Published successfully";

    }
}
