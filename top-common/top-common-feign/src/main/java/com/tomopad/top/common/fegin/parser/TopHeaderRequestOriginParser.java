package com.tomopad.top.common.fegin.parser;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;

import javax.servlet.http.HttpServletRequest;

/**
 * sentinel 请求头解析判断
 */
public class TopHeaderRequestOriginParser implements RequestOriginParser {

    /**
     * 请求头获取allow
     */
    private static final String ALLOW = "Allow";

    /**
     * Parse the origin from given HTTP request.
     * @param httpServletRequest HTTP request
     * @return parsed origin
     */
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getHeader(ALLOW);
    }
}
