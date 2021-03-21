package com.tomopad.top.common.fegin;

import com.alibaba.cloud.sentinel.feign.SentinelFeignAutoConfiguration;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import com.tomopad.top.common.fegin.ext.TopSentinelFeign;
import com.tomopad.top.common.fegin.handler.TopUrlBlockHandler;
import com.tomopad.top.common.fegin.parser.TopHeaderRequestOriginParser;
import feign.Feign;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * sentinel 配置
 */
@Configuration(proxyBeanMethods = false)
@AutoConfigureBefore(SentinelFeignAutoConfiguration.class)
public class PigFeignAutoConfiguration {

    @Bean
    @Scope("prototype")
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "feign.sentinel.enabled")
    public Feign.Builder feignSentinelBuilder(){
        return TopSentinelFeign.builder();
    }

    @Bean
    @ConditionalOnMissingBean
    public BlockExceptionHandler blockExceptionHandler(){
        return new TopUrlBlockHandler();
    }

    @Bean
    @ConditionalOnMissingBean
    public RequestOriginParser requestOriginParser(){
        return new TopHeaderRequestOriginParser();
    }

}
