package com.small.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.small.pms.entity.SpuCommentEntity;
import com.small.core.vo.PageVO;
import com.small.core.bean.QueryCondition;


/**
 * <p>
 *   商品评价
 * </p>
 *
 * @author zhangshichang
 * @email iszhangsc@gamil.com
 * @date 2020-02-13 22:28:33
 */
public interface SpuCommentService extends IService<SpuCommentEntity> {

    PageVO<SpuCommentEntity> queryPage(QueryCondition params);
}

