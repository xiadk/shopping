package com.ZIBShopping.controller;

import com.ZIBShopping.dto.OrderDto;
import com.ZIBShopping.dto.ZIBProductDto;
import com.ZIBShopping.enums.Introduce;
import com.ZIBShopping.service.IntroduceService;
import com.ZIBShopping.service.OrderService;
import com.ZIBShopping.service.ZIBProductService;
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
@RequestMapping("home")
public class HomeController {
    @Autowired
    private IntroduceService introduceService;
    @Autowired
    private ZIBProductService zibProductService;

    /**
     * 获取首页轮播图，热卖产品，推荐产品
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "viewpager", method = RequestMethod.GET)
    public Map<String, Object> viewPager() {
        //获取轮播图
        List<String> images = introduceService.find(Introduce.VIEWGAGER_IMG);
        //热卖产品
        ZIBProductDto recommendProduct = zibProductService.recommendProduct(1L);
        //推荐产品
        List<ZIBProductDto> sellingProduct = zibProductService.findPage(new Date().toString(),3);

        Map<String,Object> result = new HashMap<>();
        result.put("images",images);
        result.put("sellingProduct",sellingProduct);
        result.put("recommendProduct",recommendProduct);
        return result;
    }

}
