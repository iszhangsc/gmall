package com.small.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.small.pms.entity.SkuImagesEntity;
import com.small.core.vo.PageVO;
import com.small.core.bean.QueryCondition;


/**
 * <p>
 *   sku图片
 * </p>
 *
 * @author zhangshichang
 * @email iszhangsc@gamil.com
 * @date 2020-02-13 22:28:30
 */
public interface SkuImagesService extends IService<SkuImagesEntity> {

    PageVO<SkuImagesEntity> queryPage(QueryCondition params);
}

