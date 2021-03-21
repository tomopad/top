package com.tomopad.top.common.security.annotation;

import com.tomopad.top.common.security.component.TopResourceServerAutoConfiguration;
import com.tomopad.top.common.security.component.TopSecurityBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.lang.annotation.*;

/**
 * 资源服务注解
 */
@Documented
@Inherited
@EnableResourceServer
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import({TopResourceServerAutoConfiguration.class, TopSecurityBeanDefinitionRegistrar.class})
public @interface EnableTopResourceServer {
}
