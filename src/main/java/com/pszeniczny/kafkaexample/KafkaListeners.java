package com.pszeniczny.kafkaexample;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "pszeniczny", groupId = "groupIdFoo")
    void listener(String data) {
        System.out.println("Received from kafka: " + data.getBytes(StandardCharsets.UTF_8));
    }

}
