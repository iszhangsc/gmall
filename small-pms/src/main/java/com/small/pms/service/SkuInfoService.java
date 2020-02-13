package com.small.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.small.pms.entity.SkuInfoEntity;
import com.small.core.vo.PageVO;
import com.small.core.bean.QueryCondition;


/**
 * <p>
 *   sku信息
 * </p>
 *
 * @author zhangshichang
 * @email iszhangsc@gamil.com
 * @date 2020-02-13 22:28:31
 */
public interface SkuInfoService extends IService<SkuInfoEntity> {

    PageVO<SkuInfoEntity> queryPage(QueryCondition params);
}

