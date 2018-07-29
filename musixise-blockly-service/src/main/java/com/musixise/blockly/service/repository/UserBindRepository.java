package com.musixise.blockly.service.repository;

import com.musixise.blockly.service.domain.UserBind;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zhaowei on 2018/4/5.
 */
public interface UserBindRepository extends JpaRepository<UserBind, Long> {
    UserBind findByOpenId(String openId);
    UserBind findByOpenIdAndProvider(String openId, String provider);
    List<UserBind> findAllByLogin(String login);
}
