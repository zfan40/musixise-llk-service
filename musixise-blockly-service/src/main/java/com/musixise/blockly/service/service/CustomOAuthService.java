package com.musixise.blockly.service.service;

import com.musixise.blockly.api.web.vo.resp.SocialVO;
import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;

/**
 * Created by zhaowei on 2018/4/5.
 */
public interface CustomOAuthService extends OAuthService {

    String getoAuthType();
    String getAuthorizationUrl();
    SocialVO getOAuthUser(Token accessToken);

}
