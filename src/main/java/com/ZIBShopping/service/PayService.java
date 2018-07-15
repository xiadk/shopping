package com.ZIBShopping.service;

import com.ZIBShopping.entity.Pay;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface PayService {
    public Map<String, Object> wxPay(String openid, Pay pay, HttpServletRequest request);
}
