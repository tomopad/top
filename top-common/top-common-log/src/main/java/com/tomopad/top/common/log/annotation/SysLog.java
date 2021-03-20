package com.tomopad.top.common.log.annotation;

import java.lang.annotation.*;

/**
 * 造作日志注解
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {
    /**
     * 描述
     * @return
     */
    String value();
}
