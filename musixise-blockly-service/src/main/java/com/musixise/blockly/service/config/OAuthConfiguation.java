package com.musixise.blockly.service.config;

import com.musixise.blockly.service.security.social.WeixinApi;
import com.musixise.blockly.service.service.CustomOAuthService;
import org.scribe.builder.ServiceBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhaowei on 2018/4/5.
 */
@Configuration
public class OAuthConfiguation {
    private static final String CALLBACK_URL = "http://tianmaying.com/oauth/%s/callback";

    @Value("${spring.social.wechat.clientId}") String weixinAppId;
    @Value("${spring.social.wechat.clientSecret}") String weixinAppSecret;

    @Bean
    public CustomOAuthService getOAuthService(){
        return (CustomOAuthService) new ServiceBuilder()
                .provider(WeixinApi.class)
                .apiKey(weixinAppId)
                .apiSecret(weixinAppSecret)
                .scope("snsapi_login")
                .callback(String.format(CALLBACK_URL, OAuthTypesConstants.WECHAT))
                .build();
    }
}
