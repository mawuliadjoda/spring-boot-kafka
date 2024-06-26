package com.adjoda.service;

import com.adjoda.dto.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public KafkaMessagePublisher(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessageToTopic(String message) {
        CompletableFuture<SendResult<String, Object>> completableFuture = kafkaTemplate.send("adjoda-dev-demo-1", message);
        completableFuture.whenComplete((result, ex) -> {
            if(ex == null) {
                System.out.println("Sent message=[" + message + "] with offset = [" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" + message + "] due to : " + ex.getMessage());
            }
        });
    }

    public void sendEventToTopic(Customer customer) {
        try {
            CompletableFuture<SendResult<String, Object>> completableFuture = kafkaTemplate.send("adjoda-dev-demo3", customer);
            completableFuture.whenComplete((result, ex) -> {
                if(ex == null) {
                    System.out.println("Sent message=[" + customer.toString() + "] with offset = [" + result.getRecordMetadata().offset() + "]");
                } else {
                    System.out.println("Unable to send message=[" + customer.toString() + "] due to : " + ex.getMessage());
                }
            });
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
}
