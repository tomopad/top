package com.tomopad.top.gateway.config;

import com.tomopad.top.gateway.handler.ImageCodeHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

/**
 * 路由配置信息
 */
@Slf4j
@Configuration(proxyBeanMethods = false)
@RequiredArgsConstructor
public class RouterFunctionConfiguration {

    private final ImageCodeHandler imageCodeHandler;

    @Bean
    public RouterFunction routerFunction() {
        return RouterFunctions.route(
                RequestPredicates.path("/code").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), imageCodeHandler);
    }
}
