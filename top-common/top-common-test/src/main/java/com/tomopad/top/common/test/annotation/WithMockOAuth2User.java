package com.tomopad.top.common.test.annotation;

import com.tomopad.top.common.test.WithMockSecurityContextFactory;
import org.springframework.security.test.context.support.WithSecurityContext;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@WithSecurityContext(factory = WithMockSecurityContextFactory.class)
public @interface WithMockOAuth2User {
    /**
     * 用户名
     */
    String username() default "admin";

    /**
     * 密码
     */
    String password() default "123456";
}
