package com.tomopad.top.common.fegin;

import com.alibaba.cloud.sentinel.feign.SentinelFeignAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@AutoConfigureBefore(SentinelFeignAutoConfiguration.class)
public class PigFeignAutoConfiguration {

}
