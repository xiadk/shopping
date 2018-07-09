package com.ZIBShopping.controller;

import com.ZIBShopping.common.Annotation.CurrentUser;
import com.ZIBShopping.common.Annotation.LoginRequired;
import com.ZIBShopping.dto.OrderDto;
import com.ZIBShopping.dto.ShoppingCarDto;
import com.ZIBShopping.dto.ZIBProductDto;
import com.ZIBShopping.service.OrderService;
import com.ZIBShopping.service.ZIBProductService;
import com.ZIBShopping.utils.SqlInjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * zjh 2018.7.3
 */
@Controller
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @LoginRequired
    @ResponseBody
    @RequestMapping(value = "findOrders", method = RequestMethod.GET)
    public List<OrderDto> findOrders(@CurrentUser Long userId) {
        List<OrderDto> ls = orderService.findOrderDtos(userId);
        return ls;
    }

    @ResponseBody
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public Map<String, String> save(@RequestParam OrderDto orderDto) {
        Map<String, String> map = new HashMap<>();
        OrderDto order = orderService.save(orderDto);
        String val = "";
        val = order == null ? "-1" : "1";
        map.put("code", val);
        return map;
    }
}
