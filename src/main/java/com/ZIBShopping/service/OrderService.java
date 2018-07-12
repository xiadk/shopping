package com.ZIBShopping.service;

import com.ZIBShopping.dto.OrderDto;
import com.ZIBShopping.dto.ReputationDto;
import com.ZIBShopping.enums.OrderType;

import java.util.List;
import java.util.Map;

/**
 * zjh 2018.7.2
 */
public interface OrderService {
    /**
     * 根据状态查询订单
     * @param userId
     * @param type  订单状态
     * @return
     */
    List<OrderDto> findOrderDtos(Long userId, OrderType type);

    /**
     *  保存订单
     *
     * @param orderDto
     * @return
     */
    Map<String, Object> save(OrderDto orderDto);

    /**
     * 修改订单状态
     * @param id
     * @param status    状态
     * @return
     */
    Map<String,String> updateStatus(Long id,OrderType status);

    /**
     * 订单详情
     * @param id
     * @return
     */
    Map<String,Object> orderDetails(Long id);

    /**
     * 添加评论
     * @param reputationDto
     * @return
     */
    Map<String,Object> reputation(ReputationDto reputationDto);
}
