package com.brilworks.kafka.services;

import com.brilworks.kafka.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private Producer producer;

    @PostMapping("/publish")
    public void publish(@RequestParam("message") String message){
        producer.sendMessage(message);
    }
}
