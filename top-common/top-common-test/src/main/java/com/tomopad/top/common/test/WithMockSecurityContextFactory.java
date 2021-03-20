package com.tomopad.top.common.test;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import com.tomopad.top.common.core.util.SpringContextHolder;
import com.tomopad.top.common.test.annotation.WithMockOAuth2User;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

public class WithMockSecurityContextFactory implements WithSecurityContextFactory<WithMockOAuth2User> {
    @Override
    public SecurityContext createSecurityContext(WithMockOAuth2User oAuth2User) {
        // 1. 请求认证中心获取token
        String token = getToken(oAuth2User);

        // 2. 解析认证中心返回用户
        OAuth2Authentication authentication = getUser(token);

        // 3. 构建 oauth2 上下文
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);

        // 4. 上下文保存 token
        DefaultOAuth2AccessToken accessToken = new DefaultOAuth2AccessToken(token);
        OAuth2ClientContext clientContext = SpringContextHolder.getBean(OAuth2ClientContext.class);
        clientContext.setAccessToken(accessToken);
        return context;
    }
    /**
     * 使用token 获取用户详情
     * @param token token
     * @return user详细
     */
    private OAuth2Authentication getUser(String token) {
        RemoteTokenServices tokenServices = SpringContextHolder.getBean(RemoteTokenServices.class);
        return tokenServices.loadAuthentication(token);
    }
    /**
     * 请求认证中心获取token
     * @param oAuth2User 账号、密码
     * @return String token
     */
    private String getToken(WithMockOAuth2User oAuth2User) {
        OAuth2ProtectedResourceDetails clientProperties = SpringContextHolder
                .getBean(OAuth2ProtectedResourceDetails.class);

        String result = HttpRequest.post(clientProperties.getAccessTokenUri())
                .basicAuth(clientProperties.getClientId(), clientProperties.getClientSecret())
                .form("username", oAuth2User.username()).form("password", oAuth2User.password())
                .form("grant_type", "password").form("scope", clientProperties.getScope()).execute().body();
        return JSONUtil.parseObj(result).getStr("access_token");
    }
}
