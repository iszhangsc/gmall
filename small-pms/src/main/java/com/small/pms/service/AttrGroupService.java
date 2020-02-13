package com.small.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.small.pms.entity.AttrGroupEntity;
import com.small.core.vo.PageVO;
import com.small.core.bean.QueryCondition;


/**
 * <p>
 *   属性分组
 * </p>
 *
 * @author zhangshichang
 * @email iszhangsc@gamil.com
 * @date 2020-02-13 22:28:32
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageVO<AttrGroupEntity> queryPage(QueryCondition params);
}

