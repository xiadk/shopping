package com.ZIBShopping.controller;

import com.ZIBShopping.dto.ZIBProductDto;
import com.ZIBShopping.service.ZIBProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * zjh 2018.7.2
 */
@Controller
@RequestMapping("product")
public class ZIBProductController {
    @Autowired
    private ZIBProductService zibProductService;
    @ResponseBody
    @RequestMapping(value = "findProduct",method = RequestMethod.GET)
    public List<ZIBProductDto> findPlaceOfReceiptDto(@RequestParam String updateTime, @RequestParam int row){
        List<ZIBProductDto> ls = zibProductService.findPage(updateTime,row);
        return ls;
    }

    /**
     * 首页
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "recommend",method = RequestMethod.GET)
    public ZIBProductDto recommendProduct(@RequestBody Map<String,Long> map){
        return zibProductService.recommendProduct(map.get("count"));
    }
}
