package com.tomopad.top.admin.api.feign.factory;

import com.tomopad.top.admin.api.feign.RemoteLogService;
import com.tomopad.top.admin.api.feign.fallback.RemoteLogServiceFallbackImpl;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class RemoteLogServiceFallbackFactory implements FallbackFactory<RemoteLogService> {

    @Override
    public RemoteLogService create(Throwable cause) {
        RemoteLogServiceFallbackImpl remoteLogServiceFallback = new RemoteLogServiceFallbackImpl();
        remoteLogServiceFallback.setCause(cause);
        return remoteLogServiceFallback;
    }
}
