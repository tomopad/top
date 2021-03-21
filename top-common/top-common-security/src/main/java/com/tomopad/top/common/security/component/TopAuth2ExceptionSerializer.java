package com.tomopad.top.common.security.component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.tomopad.top.common.core.constant.CommonConstants;
import com.tomopad.top.common.security.excettion.TopAuth2Exception;

import java.io.IOException;

/**
 * OAuth2 异常格式化
 */
public class TopAuth2ExceptionSerializer extends StdSerializer<TopAuth2Exception> {

    public TopAuth2ExceptionSerializer() {
        super(TopAuth2Exception.class);
    }

    @Override
    public void serialize(TopAuth2Exception e, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectField("code", CommonConstants.FAIL);
        jsonGenerator.writeStringField("msg", e.getMessage());
        jsonGenerator.writeStringField("data", e.getErrorCode());
        jsonGenerator.writeEndObject();
    }
}
