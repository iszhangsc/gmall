package com.small.pms.dao;

import com.small.pms.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *   商品三级分类
 * </p>
 * 
 * @author zhangshichang
 * @email iszhangsc@gamil.com
 * @date 2020-02-13 22:28:28
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
