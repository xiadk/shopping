package com.ZIBShopping.controller;

import com.ZIBShopping.dto.PlaceOfReceiptDto;
import com.ZIBShopping.dto.ZIBProductDto;
import com.ZIBShopping.service.ZIBProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
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
    public List<ZIBProductDto> findPlaceOfReceiptDto(@RequestParam String updateTime, @RequestParam Long row){
        List<ZIBProductDto> ls = zibProductService.findPage(updateTime,row);
        return ls;
    }

    @ResponseBody
    @RequestMapping(value = "recommend",method = RequestMethod.POST)
    public ZIBProductDto recommendProduct(@RequestBody Map<String,Long> map){
        return zibProductService.recommendProduct(map.get("count"));
    }
}
