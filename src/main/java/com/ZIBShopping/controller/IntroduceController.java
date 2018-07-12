package com.ZIBShopping.controller;

import com.ZIBShopping.dto.ZIBProductDto;
import com.ZIBShopping.enums.Introduce;
import com.ZIBShopping.service.IntroduceService;
import com.ZIBShopping.service.ZIBProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * zjh 2018.7.3
 */
@Controller
@RequestMapping("introduce")
public class IntroduceController {
    @Autowired
    private IntroduceService introduceService;
    @Autowired
    private ZIBProductService zibProductService;

    /**
     * 获取介绍页面图片
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public Map<String, Object> viewPager() {
        //获取产品介绍图
        List<String> goodsImages = introduceService.find(Introduce.GOODS_INTR);
        //热卖产品
        List<String> companyImages = introduceService.find(Introduce.COMPANY_INTR);

        Map<String,Object> result = new HashMap<>();
        result.put("goodsImages",goodsImages);
        result.put("companyImages",companyImages);
        return result;
    }

}
