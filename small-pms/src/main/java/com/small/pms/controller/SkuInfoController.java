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

import com.small.pms.entity.SkuInfoEntity;
import com.small.pms.service.SkuInfoService;




/**
 * <p>
 *   sku信息
 * </p>
 *
 * @author zhangshichang
 * @email iszhangsc@gamil.com
 * @date 2020-02-13 22:28:31
 */
@Api(tags = "sku信息 管理")
@RestController
@RequestMapping("pms/skuinfo")
public class SkuInfoController {

    @Autowired
    private SkuInfoService skuInfoService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @ApiOperationSupport(author = "zhangshichang")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('pms:skuinfo:list')")
    public ResultVO<PageVO<SkuInfoEntity>> list(QueryCondition queryCondition) {
        PageVO<SkuInfoEntity> page = skuInfoService.queryPage(queryCondition);
        return ResultVO.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{skuId}")
    @ApiOperationSupport(author = "zhangshichang", order = 1)
    @PreAuthorize("hasAuthority('pms:skuinfo:info')")
    public ResultVO<SkuInfoEntity> info(@PathVariable("skuId") Long skuId){
		SkuInfoEntity skuInfo = skuInfoService.getById(skuId);

        return ResultVO.ok(skuInfo);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @ApiOperationSupport(author = "zhangshichang", order = 3)
    @PreAuthorize("hasAuthority('pms:skuinfo:save')")
    public ResultVO<Object> save(@RequestBody SkuInfoEntity skuInfo){
		skuInfoService.save(skuInfo);

        return ResultVO.ok();
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @ApiOperationSupport(author = "zhangshichang", order = 4)
    @PreAuthorize("hasAuthority('pms:skuinfo:update')")
    public ResultVO<Object> update(@RequestBody SkuInfoEntity skuInfo){
		skuInfoService.updateById(skuInfo);

        return ResultVO.ok();
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @ApiOperationSupport(author = "zhangshichang", order = 5)
    @PreAuthorize("hasAuthority('pms:skuinfo:delete')")
    public ResultVO<Object> delete(@RequestBody Long[] skuIds){
		skuInfoService.removeByIds(Arrays.asList(skuIds));

        return ResultVO.ok();
    }

}
