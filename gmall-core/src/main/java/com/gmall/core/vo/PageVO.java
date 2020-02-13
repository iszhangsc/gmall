package com.gmall.core.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 自定义分页封装类、统一分页返回
 *
 * @author zhangshichang
 * @date 19-5-9 下午7:42
 */
@Getter
@Setter
@ToString
@ApiModel(description = "分页返回对象")
public final class PageVO<T> {

    /**
     * 防止 new
     */
    private PageVO() {

    }

    private PageVO(Integer pageNum, Integer pageSize, Integer totalPage, Long total, List<T> list) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.total = total;
        this.list = list;
    }



    @ApiModelProperty(name = "pageNum", value = "页码", example = "1")
    private Integer pageNum;

    @ApiModelProperty(name = "pageSize", value = "页大小", position = 1, example = "10")
    private Integer pageSize;

    @ApiModelProperty(name = "totalPage", value = "总页数", position = 2, example = "1")
    private Integer totalPage;

    @ApiModelProperty(name = "total", value = "总条数", position = 3, example = "1")
    private Long total;

    @ApiModelProperty(name = "list", value = "数据列表", position = 4)
    private List<T> list;


    /**
     * 将 PageHelper 分页后的 list 转为分页信息
     *
     * @param list 集合数据
     * @return PageVO
     * @author zhangshichang
     * @date 19-5-9 下午7:43
     */
    public static <T> PageVO<T> list2PageVO(List<T> list) {
        PageInfo<T> pageInfo = new PageInfo<>(list);
        return new PageVO<>(pageInfo.getPageNum(),
                pageInfo.getPageSize(), pageInfo.getPages(), pageInfo.getTotal(), pageInfo.getList());
    }

    /**
     * 将PageHelper PageInfo 转为自定义分页信息
     *
     * @param pageInfo {@link PageInfo} pageHelper分页信息对象
     * @param <T>      泛型参数
     * @return {@link PageVO<T> }
     * @author zhangshichang
     * @date 19-5-9 下午7:43
     */
    public static <T> PageVO<T> pageInfo2PageVO(PageInfo<T> pageInfo) {
        return new PageVO<>(pageInfo.getPageNum(),
                pageInfo.getPageSize(), pageInfo.getPages(), pageInfo.getTotal(), pageInfo.getList());
    }

    /**
     * 将MyBatis Plus分页后的list转为分页信息
     *
     * @param iPage {@link IPage<T> } Mybatis-Plus分页信息对象
     * @param <T>   泛型参数
     * @return PageVO
     * @author zhangshichang
     * @date 19-5-9 下午7:43
     */
    public static <T> PageVO<T> iPage2PageVO(IPage<T> iPage) {
        return  new PageVO<>((int)iPage.getCurrent(), (int)iPage.getSize(),
                (int) iPage.getPages(), iPage.getTotal(), iPage.getRecords());
    }


    /**
     * 将SpringData 全家桶(JPA、ES) 分页后的list转为分页信息
     *
     * @param page {@link Page} SpringData 封装的统一分页信息
     * @param <T>      泛型参数
     * @return {@link PageVO}
     * @author zhangshichang
     * @date 19-5-9 下午7:44
     */
    @SuppressWarnings("unUse")
    public static <T> PageVO<T> page2PageVO(Page<T> page) {
        return new PageVO<>(page.getNumber(), page.getSize(),
                page.getTotalPages(), page.getTotalElements(), page.getContent());
    }


}
