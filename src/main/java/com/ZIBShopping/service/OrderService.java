package com.ZIBShopping.service;

import com.ZIBShopping.dto.OrderDto;
import java.util.List;

/**
 * zjh 2018.7.2
 */
public interface OrderService {
    List<OrderDto> findOrderDtos(Long userId);
    OrderDto save(OrderDto orderDto);
}
