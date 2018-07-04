package com.ZIBShopping.controller;

import com.ZIBShopping.dto.ShoppingCarDto;
import com.ZIBShopping.dto.ZIBProductDto;
import com.ZIBShopping.service.ShoppingCarService;
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
@RequestMapping("shoppingCar")
public class ShoppingCarController {
    @Autowired
    private ShoppingCarService shoppingCarService;

    @ResponseBody
    @RequestMapping(value = "findShoppingCar", method = RequestMethod.GET)
    public List<ShoppingCarDto> findShoppingCar(@RequestParam String userId) {
        return shoppingCarService.findShoppingCarDtos(userId);
    }

    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public Map<String,String> delete(@RequestParam Long id) {
        Map<String,String> map = new HashMap<>();
        shoppingCarService.deleteShoppingCarDto(id);
        map.put("code","1");
        return map;
    }
    @ResponseBody
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public Map<String,String> save(@RequestParam ShoppingCarDto shoppingCarDto) {
        Map<String,String> map = new HashMap<>();
        ShoppingCarDto shoppingCar = shoppingCarService.save(shoppingCarDto);
        String val = "";
        val = shoppingCar==null ? "-1":"1";
        map.put("code",val);
        return map;
    }
}
