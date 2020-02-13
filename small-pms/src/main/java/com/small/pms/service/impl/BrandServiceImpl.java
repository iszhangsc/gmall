package com.small.pms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.small.core.vo.PageVO;
import com.small.core.bean.Query;
import com.small.core.bean.QueryCondition;

import com.small.pms.dao.BrandDao;
import com.small.pms.entity.BrandEntity;
import com.small.pms.service.BrandService;

/**
 * <p>
 *   品牌
 * </p>
 *
 * @author zhangshichang
 * @email iszhangsc@gamil.com
 * @date 2020-02-13 22:28:34
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {

    @Override
    public PageVO<BrandEntity> queryPage(QueryCondition params) {
        IPage<BrandEntity> page = this.page(
                new Query<BrandEntity>().getPage(params),
                new QueryWrapper<BrandEntity>()
        );

        return PageVO.iPage2PageVO(page);
    }

}