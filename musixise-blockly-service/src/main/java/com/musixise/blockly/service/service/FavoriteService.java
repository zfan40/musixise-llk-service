package com.musixise.blockly.service.service;

/**
 * Created by zhaowei on 2018/4/5.
 */
public interface FavoriteService {

    Boolean create(Long uid, Long workId);

    Boolean cancle(Long uid, Long workId);

    Boolean isFavorite(Long uid, Long workId);

}
