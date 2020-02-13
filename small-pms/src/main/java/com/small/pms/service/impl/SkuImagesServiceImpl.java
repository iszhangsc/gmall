package com.small.pms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.small.core.vo.PageVO;
import com.small.core.bean.Query;
import com.small.core.bean.QueryCondition;

import com.small.pms.dao.SkuImagesDao;
import com.small.pms.entity.SkuImagesEntity;
import com.small.pms.service.SkuImagesService;

/**
 * <p>
 *   sku图片
 * </p>
 *
 * @author zhangshichang
 * @email iszhangsc@gamil.com
 * @date 2020-02-13 22:28:30
 */
@Service
public class SkuImagesServiceImpl extends ServiceImpl<SkuImagesDao, SkuImagesEntity> implements SkuImagesService {

    @Override
    public PageVO<SkuImagesEntity> queryPage(QueryCondition params) {
        IPage<SkuImagesEntity> page = this.page(
                new Query<SkuImagesEntity>().getPage(params),
                new QueryWrapper<SkuImagesEntity>()
        );

        return PageVO.iPage2PageVO(page);
    }

}