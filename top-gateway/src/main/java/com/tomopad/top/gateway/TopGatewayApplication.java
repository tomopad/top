package com.tomopad.top.gateway;

import com.tomopad.top.common.swagger.annotation.EnableTopSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableTopSwagger2
@EnableDiscoveryClient
@SpringBootApplication
public class TopGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(TopGatewayApplication.class, args);
    }

}
