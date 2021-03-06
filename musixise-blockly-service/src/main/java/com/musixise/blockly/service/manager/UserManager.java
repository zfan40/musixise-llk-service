package com.musixise.blockly.service.manager;

import com.musixise.blockly.api.web.vo.req.user.Register;
import com.musixise.blockly.api.web.vo.resp.SocialVO;
import com.musixise.blockly.service.config.OAuthTypesConstants;
import com.musixise.blockly.service.domain.User;
import com.musixise.blockly.service.domain.UserBind;
import com.musixise.blockly.service.repository.MusixiserRepository;
import com.musixise.blockly.service.repository.UserBindRepository;
import com.musixise.blockly.service.repository.UserRepository;
import com.musixise.blockly.service.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Created by zhaowei on 2018/4/5.
 */
@Component
public class UserManager {

    @Resource
    UserService userService;

    @Resource UserRepository userRepository;

    @Resource UserBindRepository userBindRepository;

    @Resource MusixiserRepository musixiserRepository;

    @Resource PasswordEncoder passwordEncoder;

    final private static String DEFAULT_PASSWORD="CHANGE_YOU_PASSWORD";

    public String getLoginName(String openId, String provider) {
        return String.format(OAuthTypesConstants.USERNAME, provider, openId);
    }

    @Transactional
    public String createByOauth(SocialVO socialVO) {
        String openId = socialVO.getOpenId();
        String provider = socialVO.getProvider();

        String login = getLoginName(openId, provider);
        String email = String.format("%s@musixise.com", login);

        Register register = new Register();
        register.setUsername(login);
        register.setPassword(DEFAULT_PASSWORD);
        register.setEmail(email);
        register.setRealname(socialVO.getNickName());
        register.setSmallAvatar(socialVO.getAvatar());
        register.setLargeAvatar(socialVO.getAvatar());
        register.setBirth("2000-01-01");
        register.setNation("");
        register.setTel("");
        register.setGender("");

        Long register1 = userService.register(register);
        Long userId = register1;
        if (userId > 0) {
            //bind
            bindThird(openId, login, provider, socialVO.getAccessToken(),
                    socialVO.getRefreshToken(), socialVO.getExpiresIn());
        }

        return login;
    }

    @Transactional
    public void cleanAccount(String login) {
        //query
        User byLoginExist = userRepository.findByLogin(login);
        if (byLoginExist != null) {
            //clean exist data
            musixiserRepository.deleteByUserId(byLoginExist.getId());
            userRepository.deleteById(byLoginExist.getId());
        }
    }

    public Boolean bindThird(String openId, String login, String provider, String accessToken, String refreshToken, Integer expiresIn) {
        UserBind userBind = new UserBind();
        userBind.setOpenId(openId);
        userBind.setLogin(login);
        userBind.setProvider(provider);
        if (accessToken != null) {
            userBind.setAccessToken(accessToken);
        } else {
            userBind.setAccessToken("");
        }
        if (refreshToken != null) {
            userBind.setRefreshToken(refreshToken);
        } else {
            userBind.setRefreshToken("");
        }
        if (expiresIn != null) {
            userBind.setExpiresIn(expiresIn);
        }
        UserBind save = userBindRepository.save(userBind);
        if (save.getBid() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
