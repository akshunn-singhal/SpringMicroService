package com.harman.collateral.processor.kafka.consumer;

import com.harman.collateral.processor.service.CollateralService;
import com.shared.dto.CollateralRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumer {

    private final CollateralService service;

    @KafkaListener(
            topics = "${spring.kafka.topic.name}"
            , groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(CollateralRequest request) {
        log.info("Event received in kafka listener, {}", request);
        service.saveCollateral(request);
    }
}
