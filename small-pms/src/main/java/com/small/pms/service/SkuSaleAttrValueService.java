package com.small.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.small.pms.entity.SkuSaleAttrValueEntity;
import com.small.core.vo.PageVO;
import com.small.core.bean.QueryCondition;


/**
 * <p>
 *   sku销售属性&值
 * </p>
 *
 * @author zhangshichang
 * @email iszhangsc@gamil.com
 * @date 2020-02-13 22:28:32
 */
public interface SkuSaleAttrValueService extends IService<SkuSaleAttrValueEntity> {

    PageVO<SkuSaleAttrValueEntity> queryPage(QueryCondition params);
}

