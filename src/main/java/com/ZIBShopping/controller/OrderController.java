package com.ZIBShopping.controller;

import com.ZIBShopping.common.Annotation.CurrentUser;
import com.ZIBShopping.common.Annotation.LoginRequired;
import com.ZIBShopping.dto.*;
import com.ZIBShopping.entity.Pay;
import com.ZIBShopping.enums.OrderType;
import com.ZIBShopping.service.OrderService;
import com.ZIBShopping.service.PayService;
import com.ZIBShopping.service.UserService;
import com.ZIBShopping.service.ZIBProductService;
import com.ZIBShopping.utils.OrderNumberUtils;
import com.ZIBShopping.utils.SqlInjectUtils;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    @Autowired
    private PayService payService;
    @Autowired
    private UserService userService;

    @LoginRequired
    @ResponseBody
    @RequestMapping(value = "findOrders", method = RequestMethod.GET)
    public Map<String,Object> findOrders(@CurrentUser Long userId, @RequestParam OrderType statusType) {
        Map<String,Object> map = new HashMap<>();
        List<OrderDto> ls = orderService.findOrderDtos(userId,statusType);
        Integer code = (ls==null||ls.size()<=0)? -1:0;
        map.put("code",code);
        map.put("orders",ls);
        return map;
    }

    @LoginRequired
    @ResponseBody
    @RequestMapping(value = "updateStatus", method = RequestMethod.GET)
    public Map<String, String> update(@RequestParam Long id, @RequestParam OrderType statusType) {
        return orderService.updateStatus(id,statusType);
    }

    @LoginRequired
    @ResponseBody
    @RequestMapping(value = "orderDetails", method = RequestMethod.GET)
    public Map<String, Object> orderDetails(@RequestParam Long id) {
        return orderService.orderDetails(id);
    }

    @LoginRequired
    @ResponseBody
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public Map<String, Object> save(@RequestBody OrderDto orderDto,@CurrentUser Long userId) {
        orderDto.setUserId(userId);
        orderDto.setOrderNumber(OrderNumberUtils.getOrderNum(userId,new Date(),orderDto.getProductId()));
        return orderService.save(orderDto);
    }

    @LoginRequired
    @ResponseBody
    @RequestMapping(value = "reputation", method = RequestMethod.POST)
    public Map<String,Object> reputation(@CurrentUser Long userId, @RequestBody ReputationDto reputationDto) {
        reputationDto.setUserId(userId);
        return orderService.reputation(reputationDto);
    }

    /**
     * 付款
     * @param userId
     * @param pay
     * @return
     */
    @LoginRequired
    @ResponseBody
    @RequestMapping(value = "pay", method = RequestMethod.POST)
    public Map<String,Object> pay(@CurrentUser Long userId, @RequestBody Pay pay,HttpServletRequest request) {
        String openId = userService.getOpenId(userId);
        Map<String,Object> map = payService.wxPay(openId,pay,request);
        map.put("code","-1");
        if(map!=null){
            //修改订单状态
            orderService.updateStatus(1l,OrderType.AWAIT_SEND);
            map.put("code","1");
        }

        return map;
    }
}
