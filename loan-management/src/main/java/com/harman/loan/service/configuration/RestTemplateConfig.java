package com.harman.loan.service.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateConfig {
    @Bean
    public RestTemplate getRestTemplateInstance() {
        return new RestTemplate();
        //ideally this should be a ConnectionPool
    }
}
