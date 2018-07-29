package com.musixise.blockly.service.manager;

import com.musixise.blockly.api.web.vo.resp.UserVO;
import com.musixise.blockly.api.web.vo.resp.work.WorkVO;
import com.musixise.blockly.service.domain.Work;
import com.musixise.blockly.service.service.FavoriteService;
import com.musixise.blockly.service.service.FollowService;
import com.musixise.blockly.service.service.UserService;
import com.musixise.blockly.service.transfter.WorkTransfter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by zhaowei on 2018/4/15.
 */
@Component("workManager")
public class WorkManager {

    @Resource
    UserService userService;

    @Resource
    FavoriteService favoriteService;

    @Resource
    FollowService followService;

    public WorkVO getWorkVO(Long uid, Work work) {
        UserVO userVO = userService.getById(work.getUserId(), false);
        Boolean isFavorite = favoriteService.isFavorite(uid, work.getId());
        Boolean isFollow = followService.isFollow(uid, work.getUserId());
        userVO.setFollowStatus(isFollow ? 1 : 0);
        return WorkTransfter.getWorkVO(work, userVO, isFavorite);
    }
}
