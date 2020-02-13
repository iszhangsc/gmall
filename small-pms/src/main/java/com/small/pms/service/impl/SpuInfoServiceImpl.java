package com.small.pms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.small.core.vo.PageVO;
import com.small.core.bean.Query;
import com.small.core.bean.QueryCondition;

import com.small.pms.dao.SpuInfoDao;
import com.small.pms.entity.SpuInfoEntity;
import com.small.pms.service.SpuInfoService;

/**
 * <p>
 *   spu信息
 * </p>
 *
 * @author zhangshichang
 * @email iszhangsc@gamil.com
 * @date 2020-02-13 22:28:35
 */
@Service
public class SpuInfoServiceImpl extends ServiceImpl<SpuInfoDao, SpuInfoEntity> implements SpuInfoService {

    @Override
    public PageVO<SpuInfoEntity> queryPage(QueryCondition params) {
        IPage<SpuInfoEntity> page = this.page(
                new Query<SpuInfoEntity>().getPage(params),
                new QueryWrapper<SpuInfoEntity>()
        );

        return PageVO.iPage2PageVO(page);
    }

}