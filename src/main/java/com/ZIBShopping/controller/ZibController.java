package com.ZIBShopping.controller;

import com.ZIBShopping.dto.OrderDto;
import com.ZIBShopping.enums.Introduce;
import com.ZIBShopping.service.IntroduceService;
import com.ZIBShopping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * zjh 2018.7.3
 */
@Controller
@RequestMapping("zib")
public class ZibController {
    @Autowired
    private IntroduceService introduceService;

    @ResponseBody
    @RequestMapping(value = "viewpager", method = RequestMethod.GET)
    public Map<String, List<String>> findOrders() {
        Map<String, List<String>> ls = introduceService.findAll();
        return ls;
    }

}
