package com.small.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.small.pms.entity.SpuInfoEntity;
import com.small.core.vo.PageVO;
import com.small.core.bean.QueryCondition;


/**
 * <p>
 *   spu信息
 * </p>
 *
 * @author zhangshichang
 * @email iszhangsc@gamil.com
 * @date 2020-02-13 22:28:35
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageVO<SpuInfoEntity> queryPage(QueryCondition params);
}

