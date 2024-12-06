package com.harman.loan.service.kafka.producer;

import com.shared.dto.CollateralRequest;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class CollateralProducer {

    private final NewTopic topic;
    private final KafkaTemplate<String, CollateralRequest> kafkaTemplate;

    public CompletableFuture<SendResult<String, CollateralRequest>> sendMessage(CollateralRequest event){
        return kafkaTemplate.send(topic.name(), event);
    }
}
