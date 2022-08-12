package com.brilworks.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;

import static com.brilworks.kafka.services.Constant.INPUT_TOPIC;

@Service
public class Producer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendMessage(String message){
        kafkaTemplate.send(INPUT_TOPIC, "KEY",message);
    }

}
