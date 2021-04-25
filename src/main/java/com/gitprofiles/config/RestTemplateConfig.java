package com.gitprofiles.config;

import com.gitprofiles.client.ClientResponseErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    private ClientResponseErrorHandler clientResponseErrorHandler;

    @Autowired
    public RestTemplateConfig(ClientResponseErrorHandler clientResponseErrorHandler) {
        this.clientResponseErrorHandler = clientResponseErrorHandler;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().errorHandler(clientResponseErrorHandler).build();
    }
}
