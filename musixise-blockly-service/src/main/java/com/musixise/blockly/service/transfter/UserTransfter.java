package com.musixise.blockly.service.transfter;

import com.musixise.blockly.api.web.vo.resp.UserVO;
import com.musixise.blockly.service.domain.Musixiser;
import com.musixise.blockly.service.domain.User;
import com.musixise.blockly.service.utils.CommonUtil;
import com.musixise.blockly.service.utils.DateUtil;
import com.musixise.blockly.service.utils.FileUtil;

/**
 * Created by zhaowei on 2018/4/3.
 */
public class UserTransfter {

    public static UserVO getUserDetail(Musixiser musixiser, User user) {
        UserVO userVO = new UserVO();
        CommonUtil.copyPropertiesIgnoreNull(musixiser, userVO);
        userVO.setUsername(user.getLogin());
        userVO.setEmail(user.getEmail());
        userVO.setCreatedDate(DateUtil.asDate(musixiser.getCreatedDate()));
        userVO.setSmallAvatar(FileUtil.getImageFullName(userVO.getSmallAvatar()));
        userVO.setLargeAvatar(FileUtil.getImageFullName(userVO.getSmallAvatar()));

        return userVO;
    }
}
