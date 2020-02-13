package com.small.pms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.small.core.vo.PageVO;
import com.small.core.bean.Query;
import com.small.core.bean.QueryCondition;

import com.small.pms.dao.SpuCommentDao;
import com.small.pms.entity.SpuCommentEntity;
import com.small.pms.service.SpuCommentService;

/**
 * <p>
 *   商品评价
 * </p>
 *
 * @author zhangshichang
 * @email iszhangsc@gamil.com
 * @date 2020-02-13 22:28:33
 */
@Service
public class SpuCommentServiceImpl extends ServiceImpl<SpuCommentDao, SpuCommentEntity> implements SpuCommentService {

    @Override
    public PageVO<SpuCommentEntity> queryPage(QueryCondition params) {
        IPage<SpuCommentEntity> page = this.page(
                new Query<SpuCommentEntity>().getPage(params),
                new QueryWrapper<SpuCommentEntity>()
        );

        return PageVO.iPage2PageVO(page);
    }

}