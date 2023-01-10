package com;

import com.medium.service.BlogService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MediumApplication {

    public static void main(String[] args) {
        SpringApplication.run(MediumApplication.class, args);
    }
    @Bean
    public BlogService blogService() {
        return new BlogService();
    }
}
