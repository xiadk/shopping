package com.ZIBShopping.service;

import com.ZIBShopping.dto.ZIBProductDto;
import java.util.List;

/**
 * zjh 2018.7.2
 */
public interface ZIBProductService {
    /**
     * 查询产品
     *
     * @param updateTime 时间条件
     * @param row        每次列出数量
     * @return
     */
    List<ZIBProductDto> findPage(String updateTime, int row);

    /**
     * 推荐商品
     *
     * @param count 推荐数量
     * @return
     */
    ZIBProductDto recommendProduct(Long count);
}
