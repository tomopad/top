package com.tomopad.top.common.security.excettion;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tomopad.top.common.security.component.TopAuth2ExceptionSerializer;
import org.springframework.http.HttpStatus;


@JsonSerialize(using = TopAuth2ExceptionSerializer.class)
public class ForbiddenException extends TopAuth2Exception{

    public ForbiddenException(String msg, Throwable t) {
        super(msg);
    }

    @Override
    public String getOAuth2ErrorCode() {
        return "access_denied";
    }

    @Override
    public int getHttpErrorCode() {
        return HttpStatus.FORBIDDEN.value();
    }

}
