package com.smoothstack.avalanche.lmssecure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class LmsSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(LmsSecurityApplication.class, args);
    }
    
	@Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
