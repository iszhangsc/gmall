package com.small.pms.controller;

import java.util.Arrays;
import java.util.Map;


import com.small.core.vo.PageVO;
import com.small.core.bean.QueryCondition;
import com.small.core.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiOperationSupport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.small.pms.entity.CommentReplayEntity;
import com.small.pms.service.CommentReplayService;




/**
 * <p>
 *   商品评价回复关系
 * </p>
 *
 * @author zhangshichang
 * @email iszhangsc@gamil.com
 * @date 2020-02-13 22:28:29
 */
@Api(tags = "商品评价回复关系 管理")
@RestController
@RequestMapping("pms/commentreplay")
public class CommentReplayController {

    @Autowired
    private CommentReplayService commentReplayService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @ApiOperationSupport(author = "zhangshichang")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('pms:commentreplay:list')")
    public ResultVO<PageVO<CommentReplayEntity>> list(QueryCondition queryCondition) {
        PageVO<CommentReplayEntity> page = commentReplayService.queryPage(queryCondition);
        return ResultVO.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @ApiOperationSupport(author = "zhangshichang", order = 1)
    @PreAuthorize("hasAuthority('pms:commentreplay:info')")
    public ResultVO<CommentReplayEntity> info(@PathVariable("id") Long id){
		CommentReplayEntity commentReplay = commentReplayService.getById(id);

        return ResultVO.ok(commentReplay);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @ApiOperationSupport(author = "zhangshichang", order = 3)
    @PreAuthorize("hasAuthority('pms:commentreplay:save')")
    public ResultVO<Object> save(@RequestBody CommentReplayEntity commentReplay){
		commentReplayService.save(commentReplay);

        return ResultVO.ok();
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @ApiOperationSupport(author = "zhangshichang", order = 4)
    @PreAuthorize("hasAuthority('pms:commentreplay:update')")
    public ResultVO<Object> update(@RequestBody CommentReplayEntity commentReplay){
		commentReplayService.updateById(commentReplay);

        return ResultVO.ok();
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @ApiOperationSupport(author = "zhangshichang", order = 5)
    @PreAuthorize("hasAuthority('pms:commentreplay:delete')")
    public ResultVO<Object> delete(@RequestBody Long[] ids){
		commentReplayService.removeByIds(Arrays.asList(ids));

        return ResultVO.ok();
    }

}
