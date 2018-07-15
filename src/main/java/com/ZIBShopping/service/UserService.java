package com.ZIBShopping.service;

import com.ZIBShopping.common.ResultInfo;

import java.util.Map;

/**
 * xdk 2018.7.4
 */
public interface UserService {

    //获取登录凭证
    ResultInfo save(Map<String, Object> userInfo);
    //查询用户信息
    ResultInfo findUserByOpenid(String openid);
    String getOpenId(Long userId);
}
