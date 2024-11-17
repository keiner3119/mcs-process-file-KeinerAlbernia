package com.main.init.configs;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.init.utilities.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, Constants.VALUE_TRUE);
        return mapper;
    }
}