package com.ZIBShopping.service.impl;

import com.ZIBShopping.dao.OrderDao;
import com.ZIBShopping.dao.ZIBProductDao;
import com.ZIBShopping.dto.OrderDto;
import com.ZIBShopping.dto.ZIBProductDto;
import com.ZIBShopping.service.OrderService;
import com.ZIBShopping.service.ZIBProductService;
import com.ZIBShopping.utils.SqlInjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Order;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * zjh 2018.7.2
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public List<OrderDto> findOrderDtos(Long userId) {
        return orderDao.findOrderDtosByUserId(userId);
    }

    @Override
    public OrderDto save(OrderDto orderDto) {
        return orderDao.save(orderDto);
    }
}
