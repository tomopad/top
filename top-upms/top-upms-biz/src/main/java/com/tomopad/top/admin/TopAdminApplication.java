package com.tomopad.top.admin;

import com.tomopad.top.common.fegin.annotation.EnableTopFeignClients;
import com.tomopad.top.common.security.annotation.EnableTopResourceServer;
import com.tomopad.top.common.swagger.annotation.EnableTopSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 用户统一管理系统
 */
@EnableTopSwagger2
@EnableTopResourceServer
@EnableTopFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class TopAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(TopAdminApplication.class, args);
    }

}
