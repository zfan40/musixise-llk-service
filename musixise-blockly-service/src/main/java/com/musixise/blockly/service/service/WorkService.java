package com.musixise.blockly.service.service;


import com.musixise.blockly.api.web.vo.resp.work.WorkVO;

/**
 * Created by zhaowei on 2018/4/4.
 */
public interface WorkService {

    WorkVO getListByUid(Long uid);

    void updateFavoriteCount(Long workId);
}
