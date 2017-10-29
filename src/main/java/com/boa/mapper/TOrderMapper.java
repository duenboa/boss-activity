package com.boa.mapper;

import com.boa.common.util.pagination.Page;
import com.boa.entity.TOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Administrator
 */
@Repository
public interface TOrderMapper extends BaseMapper<TOrder, Long> {

    /**
     * 条件查询积分流水记录
     *
     * @param page 分页
     * @return List List
     */
    List<TOrder> findPageOrderByCreateDate(Page page);
}