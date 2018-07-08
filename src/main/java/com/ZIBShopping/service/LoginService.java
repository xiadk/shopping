package com.ZIBShopping.service;

import com.ZIBShopping.common.ResultInfo;
import com.ZIBShopping.dto.OrderDto;

import java.util.List;
import java.util.Map;

/**
 * xdk 2018.7.4
 */
public interface LoginService {

    //获取登录凭证
    ResultInfo getToken(Map<String,Object> userInfo);
}
