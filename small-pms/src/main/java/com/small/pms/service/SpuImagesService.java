package com.small.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.small.pms.entity.SpuImagesEntity;
import com.small.core.vo.PageVO;
import com.small.core.bean.QueryCondition;


/**
 * <p>
 *   spu图片
 * </p>
 *
 * @author zhangshichang
 * @email iszhangsc@gamil.com
 * @date 2020-02-13 22:28:34
 */
public interface SpuImagesService extends IService<SpuImagesEntity> {

    PageVO<SpuImagesEntity> queryPage(QueryCondition params);
}

