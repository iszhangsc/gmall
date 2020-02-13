package com.small.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.small.pms.entity.ProductAttrValueEntity;
import com.small.core.vo.PageVO;
import com.small.core.bean.QueryCondition;


/**
 * <p>
 *   spu属性值
 * </p>
 *
 * @author zhangshichang
 * @email iszhangsc@gamil.com
 * @date 2020-02-13 22:28:29
 */
public interface ProductAttrValueService extends IService<ProductAttrValueEntity> {

    PageVO<ProductAttrValueEntity> queryPage(QueryCondition params);
}

