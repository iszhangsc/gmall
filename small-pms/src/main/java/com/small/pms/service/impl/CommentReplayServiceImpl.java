package com.small.pms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.small.core.vo.PageVO;
import com.small.core.bean.Query;
import com.small.core.bean.QueryCondition;

import com.small.pms.dao.CommentReplayDao;
import com.small.pms.entity.CommentReplayEntity;
import com.small.pms.service.CommentReplayService;

/**
 * <p>
 *   商品评价回复关系
 * </p>
 *
 * @author zhangshichang
 * @email iszhangsc@gamil.com
 * @date 2020-02-13 22:28:29
 */
@Service
public class CommentReplayServiceImpl extends ServiceImpl<CommentReplayDao, CommentReplayEntity> implements CommentReplayService {

    @Override
    public PageVO<CommentReplayEntity> queryPage(QueryCondition params) {
        IPage<CommentReplayEntity> page = this.page(
                new Query<CommentReplayEntity>().getPage(params),
                new QueryWrapper<CommentReplayEntity>()
        );

        return PageVO.iPage2PageVO(page);
    }

}