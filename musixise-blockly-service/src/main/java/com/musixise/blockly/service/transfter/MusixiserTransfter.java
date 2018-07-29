package com.musixise.blockly.service.transfter;

import com.musixise.blockly.api.admin.vo.common.MusixiserVO;
import com.musixise.blockly.service.domain.Musixiser;
import com.musixise.blockly.service.utils.CommonUtil;
import com.musixise.blockly.service.utils.DateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaowei on 2018/5/11.
 */
public class MusixiserTransfter {

    public static Musixiser getMusixiser(MusixiserVO musixiserVO) {
        Musixiser musixiser = new Musixiser();
        CommonUtil.copyPropertiesIgnoreNull(musixiserVO, musixiser);
        return musixiser;
    }

    public static MusixiserVO getMusixiserVO(Musixiser musixiser) {

        MusixiserVO musixiserVO = new MusixiserVO();
        CommonUtil.copyPropertiesIgnoreNull(musixiser, musixiserVO);
        musixiserVO.setCreatedDate(DateUtil.asDate(musixiser.getCreatedDate()));
        return musixiserVO;
    }

    public static List<MusixiserVO> getMusixiserVOS(List<Musixiser> musixiserList) {
        List<MusixiserVO> musixiserVOList = new ArrayList<>();
        for (Musixiser musixiser : musixiserList) {
            MusixiserVO musixiserVO = getMusixiserVO(musixiser);
            musixiserVOList.add(musixiserVO);
        }

        return musixiserVOList;
    }
}
