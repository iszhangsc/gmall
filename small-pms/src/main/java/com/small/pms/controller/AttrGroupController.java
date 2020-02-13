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

import com.small.pms.entity.AttrGroupEntity;
import com.small.pms.service.AttrGroupService;




/**
 * <p>
 *   属性分组
 * </p>
 *
 * @author zhangshichang
 * @email iszhangsc@gamil.com
 * @date 2020-02-13 22:28:32
 */
@Api(tags = "属性分组 管理")
@RestController
@RequestMapping("pms/attrgroup")
public class AttrGroupController {

    @Autowired
    private AttrGroupService attrGroupService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @ApiOperationSupport(author = "zhangshichang")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('pms:attrgroup:list')")
    public ResultVO<PageVO<AttrGroupEntity>> list(QueryCondition queryCondition) {
        PageVO<AttrGroupEntity> page = attrGroupService.queryPage(queryCondition);
        return ResultVO.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{attrGroupId}")
    @ApiOperationSupport(author = "zhangshichang", order = 1)
    @PreAuthorize("hasAuthority('pms:attrgroup:info')")
    public ResultVO<AttrGroupEntity> info(@PathVariable("attrGroupId") Long attrGroupId){
		AttrGroupEntity attrGroup = attrGroupService.getById(attrGroupId);

        return ResultVO.ok(attrGroup);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @ApiOperationSupport(author = "zhangshichang", order = 3)
    @PreAuthorize("hasAuthority('pms:attrgroup:save')")
    public ResultVO<Object> save(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.save(attrGroup);

        return ResultVO.ok();
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @ApiOperationSupport(author = "zhangshichang", order = 4)
    @PreAuthorize("hasAuthority('pms:attrgroup:update')")
    public ResultVO<Object> update(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.updateById(attrGroup);

        return ResultVO.ok();
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @ApiOperationSupport(author = "zhangshichang", order = 5)
    @PreAuthorize("hasAuthority('pms:attrgroup:delete')")
    public ResultVO<Object> delete(@RequestBody Long[] attrGroupIds){
		attrGroupService.removeByIds(Arrays.asList(attrGroupIds));

        return ResultVO.ok();
    }

}
