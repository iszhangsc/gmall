package com.small.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.small.pms.entity.CategoryEntity;
import com.small.core.vo.PageVO;
import com.small.core.bean.QueryCondition;


/**
 * <p>
 *   商品三级分类
 * </p>
 *
 * @author zhangshichang
 * @email iszhangsc@gamil.com
 * @date 2020-02-13 22:28:28
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageVO<CategoryEntity> queryPage(QueryCondition params);
}

