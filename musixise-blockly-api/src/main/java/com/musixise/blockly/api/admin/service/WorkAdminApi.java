package com.musixise.blockly.api.admin.service;

import com.musixise.blockly.api.result.MusixiseResponse;
import com.musixise.blockly.api.result.MusixisePageResponse;
import com.musixise.blockly.api.web.vo.resp.work.WorkVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by zhaowei on 2018/5/12.
 */
@Api(value = "作品基本信息", description = "作品基本信息管理")
public interface WorkAdminApi {

    @ApiOperation(value = "获取列表")
    MusixisePageResponse<List<WorkVO>> list(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                   @RequestParam(value = "size", defaultValue = "10") Integer size);

    @ApiOperation(value = "更新信息一条")
    MusixiseResponse update(@Valid @RequestBody WorkVO workVO);

    @ApiOperation(value = "获取一条信息")
    MusixiseResponse<WorkVO> get(@PathVariable Long id);

    @ApiOperation(value = "删除一条信息")
    MusixiseResponse deleteById(@PathVariable Long id);

}
