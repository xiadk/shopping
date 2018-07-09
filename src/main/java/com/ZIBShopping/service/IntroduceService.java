package com.ZIBShopping.service;

import com.ZIBShopping.dto.IntrodueDto;
import com.ZIBShopping.dto.OrderDto;
import com.ZIBShopping.enums.Introduce;

import java.util.List;
import java.util.Map;

/**
 * zjh 2018.7.8
 */
public interface IntroduceService {
    List<String> find(Introduce name);
    Map<String,List<String>> findAll();
}
