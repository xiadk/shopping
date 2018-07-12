package com.ZIBShopping.service.impl;

import com.ZIBShopping.dao.*;
import com.ZIBShopping.dto.*;
import com.ZIBShopping.enums.OrderType;
import com.ZIBShopping.service.OrderService;
import com.ZIBShopping.service.ZIBProductService;
import com.ZIBShopping.utils.OrderStatusUtils;
import com.ZIBShopping.utils.SqlInjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Order;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * zjh 2018.7.2
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private PlaceOfReceiptDao placeDao;
    @Autowired
    private LogisticsDao logisticsDao;
    @Autowired
    private ReputationDao reputationDao;

    @Override
    public List<OrderDto> findOrderDtos(Long userId, OrderType type) {
        return orderDao.findOrderDtosByUserIdAndStatusValue(userId, type.getName());
    }

    @Override
    public Map<String, Object> save(OrderDto orderDto) {
        Map<String, Object> map = new HashMap<>();
        OrderDto order = orderDao.save(orderDto);
        String val = "";
        val = order == null ? "-1" : "1";
        map.put("code", val);
        map.put("msg","订单失效");
        return map;
    }

    @Transactional
    @Override
    public Map<String, String> updateStatus(Long id, OrderType status) {
        Map<String, String> map = new HashMap<>();
        Long statusCode = OrderStatusUtils.getStatus(status);
        map.put("code", "-1");
        if (id > 0 && status!=null) {
            orderDao.update(id, status.getName(),statusCode);
            map.put("code", "1");
        }
        return map;
    }

    @Override
    public Map<String, Object> orderDetails(Long id) {
        Map<String, Object> map = new HashMap<>();
        OrderDto order = orderDao.findOrderDtoById(id);
        PlaceOfReceiptDto place = placeDao.findPlaceOfReceiptDtoById(Long.parseLong(order.getPlaceOfReceiptId()));
        map.put("order",order);
        map.put("place",place);
        if(StringUtils.isNotEmpty(order.getLogisticsId())){
            LogisticsDto logistics = logisticsDao.findLogisticsDtoById(Long.parseLong(order.getLogisticsId()));
            map.put("logistics",logistics);
        }
        return map;
    }

    @Override
    public Map<String, Object> reputation(ReputationDto reputationDto) {
        ReputationDto reputation = reputationDao.save(reputationDto);
        Map<String, Object> map = new HashMap<>();
        map.put("code","1");
        if(reputation==null){
            map.put("code","-1");
        }
        return map;
    }
}
