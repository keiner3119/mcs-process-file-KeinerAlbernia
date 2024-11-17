package com.main.persistence.configs;

import com.main.persistence.entities.Category;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Bean
    public Class<Category> categoryClass() {
        return Category.class;
    }
}