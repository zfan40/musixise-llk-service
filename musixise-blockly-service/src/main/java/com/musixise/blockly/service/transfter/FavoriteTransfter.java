package com.musixise.blockly.service.transfter;

import com.musixise.blockly.api.web.vo.resp.favorite.FavoriteVO;
import com.musixise.blockly.api.web.vo.resp.work.WorkVO;
import com.musixise.blockly.service.domain.Favorite;
import com.musixise.blockly.service.utils.CommonUtil;
import com.musixise.blockly.service.utils.DateUtil;

/**
 * Created by zhaowei on 2018/4/5.
 */
public class FavoriteTransfter {

    public static FavoriteVO getFavoriteVO(Favorite favorite) {
        FavoriteVO favoriteVO = new FavoriteVO();
        CommonUtil.copyPropertiesIgnoreNull(favorite, favoriteVO);
        favoriteVO.setCreatedDate(DateUtil.asDate(favorite.getCreatedDate()));
        return favoriteVO;
    }

    public static FavoriteVO getFavoriteWithUser(WorkVO workVO) {
        FavoriteVO favoriteVO = new FavoriteVO();
        CommonUtil.copyPropertiesIgnoreNull(workVO, favoriteVO);
        favoriteVO.setUser(workVO.getUserVO());
        return favoriteVO;
    }

}
