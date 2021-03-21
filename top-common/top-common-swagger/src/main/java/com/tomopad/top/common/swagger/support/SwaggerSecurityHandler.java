package com.tomopad.top.common.swagger.support;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;

import java.util.Optional;

@Slf4j
@Component
public class SwaggerSecurityHandler implements HandlerFunction<ServerResponse> {

    @Autowired(required = false)
    private SecurityConfiguration securityConfiguration;

    /**
     * Handle the given request.
     * @param serverRequest the request to handler
     * @return the response
     */
    @Override
    public Mono<ServerResponse> handle(ServerRequest serverRequest) {
        return ServerResponse.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(Optional.ofNullable(securityConfiguration)
                        .orElse(SecurityConfigurationBuilder.builder().build())));
    }
}
