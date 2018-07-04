package com.ZIBShopping.controller;

import com.ZIBShopping.dto.ProductDetailsDto;
import com.ZIBShopping.dto.ZIBProductDto;
import com.ZIBShopping.service.ProductDetailsService;
import com.ZIBShopping.service.ZIBProductService;
import com.ZIBShopping.utils.ImgUrlUtils;
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
 * zjh 2018.7.2
 */
@Controller
@RequestMapping("details")
public class ProductDetailsController {
    @Autowired
    private ProductDetailsService productDetailsService;
    @ResponseBody
    @RequestMapping(value = "productDetails",method = RequestMethod.GET)
    public Map<String,List<String>> findPlaceOfReceiptDto(@RequestParam Long productId){
        Map<String,List<String>> map = new HashMap<>();
        ProductDetailsDto detailsDto = productDetailsService.findProductDetailsDto(productId);
        if(detailsDto!=null){
            map.put("img", ImgUrlUtils.analysis(detailsDto.getImgUrl(),";"));
            map.put("viewpager", ImgUrlUtils.analysis(detailsDto.getViewpagerUrl(),";"));
        }
        return map;
    }
}
