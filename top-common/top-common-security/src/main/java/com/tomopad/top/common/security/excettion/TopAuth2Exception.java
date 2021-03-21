package com.tomopad.top.common.security.excettion;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tomopad.top.common.security.component.TopAuth2ExceptionSerializer;
import lombok.Getter;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * 自定义OAuth2Exception
 */
@JsonSerialize(using = TopAuth2ExceptionSerializer.class)
public class TopAuth2Exception extends OAuth2Exception {

    @Getter
    private String errorCode;

    public TopAuth2Exception(String msg, String errorCode) {
        super(msg);
        this.errorCode = errorCode;
    }

    public TopAuth2Exception(String msg) {
        super(msg);
    }
}
