package com.tomopad.top.auth;

import com.tomopad.top.common.fegin.annotation.EnableTopFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableTopFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class TopAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(TopAuthApplication.class, args);
    }

}
