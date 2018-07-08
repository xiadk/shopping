package com.ZIBShopping.controller;

import com.ZIBShopping.common.Annotation.CurrentUser;
import com.ZIBShopping.common.Annotation.LoginRequired;
import com.ZIBShopping.common.ResultInfo;
import com.ZIBShopping.common.WeixiConfig;
import com.ZIBShopping.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private WeixiConfig config;
    @Autowired
    private LoginService loginService;

    @ResponseBody
    @RequestMapping(value = "/getToken", method = RequestMethod.POST)
    public Map<String, Object> getToken(@RequestBody Map<String, Object> userInfo) {
        String code = (String) userInfo.get("code");
        Map<String, Object> map = new HashMap<>();

        if (StringUtils.isBlank(code)) {
            map.put("code", "-1");
            map.put("msg", "code为空");

            return map;
        }
        ResultInfo resultInfo = loginService.getToken(userInfo);

        map.put("code", resultInfo.code);
        map.put("msg", resultInfo.msg);
        map.put("token", resultInfo.obj);

        return map;
    }

}
