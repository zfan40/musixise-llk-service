package com.musixise.blockly.service.service.impl;

import com.musixise.blockly.api.web.vo.resp.work.WorkVO;
import com.musixise.blockly.service.repository.FavoriteRepository;
import com.musixise.blockly.service.repository.WorkRepository;
import com.musixise.blockly.service.service.WorkService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Created by zhaowei on 2018/4/5.
 */
@Component
public class WorkServiceImpl implements WorkService {

    @Resource
    WorkRepository workRepository;

    @Resource
    FavoriteRepository favoriteRepository;

    @Override
    public WorkVO getListByUid(Long uid) {
        return null;
    }

    @Async
    @Transactional
    @Override
    public void updateFavoriteCount(Long workId) {
        int favNum = favoriteRepository.countByWorkId(workId);
        workRepository.updateCollectNumById(workId, favNum);
    }
}
