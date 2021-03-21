package com.tomopad.top.common.swagger.annotation;

import com.tomopad.top.common.swagger.config.GatewaySwaggerAutoConfiguration;
import com.tomopad.top.common.swagger.config.SwaggerAutoConfiguration;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.annotation.*;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@EnableSwagger2
@Import({ SwaggerAutoConfiguration.class, GatewaySwaggerAutoConfiguration.class })
public @interface EnableTopSwagger2 {
}
