package com.ZIBShopping.service.impl;

import com.ZIBShopping.common.Constants;
import com.ZIBShopping.common.ResultInfo;
import com.ZIBShopping.common.WeixiConfig;
import com.ZIBShopping.dao.UserDao;
import com.ZIBShopping.dto.UserDto;
import com.ZIBShopping.service.LoginService;
import com.ZIBShopping.service.UserService;
import com.ZIBShopping.utils.HttpUtils;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServierImpl implements UserService {

    @Autowired
    private UserDao userDao;
    private static Logger log = Logger.getLogger(HttpUtils.class);

    @Override
    public ResultInfo save(Map<String, Object> userInfo) {
        ResultInfo resultInfo = new ResultInfo();
        UserDto userDto = new UserDto();
        userDto.setName((String)userInfo.get("nickName"));
        userDto.setCity((String)userInfo.get("city"));
        userDto.setCountry((String)userInfo.get("country"));
        userDto.setProvince((String)userInfo.get("province"));
        userDto.setImageUrl((String)userInfo.get("avatarUrl"));
        userDto.setGender((int)userInfo.get("gender"));
        userDto.setLanguage((String)userInfo.get("language"));
        userDto.setOpenid((String)userInfo.get("openid"));
        try {

            UserDto userDto1 = userDao.save(userDto);
            resultInfo.code = 1;
            resultInfo.msg = "添加用户成功";
            resultInfo.obj = userDto1.getId();

            return resultInfo;
        } catch (Exception e) {
            resultInfo.code=-1;
            resultInfo.msg = "添加用户失败";
            log.error(e.getMessage());

            return resultInfo;

        }
    }

    @Override
    public ResultInfo findUserByOpenid(String openid) {

        return null;
    }

    @Override
    public String getOpenId(Long userId) {
        UserDto user = userDao.findUserDtoById(userId);
        if(user==null){
            return null;
        }
        return user.getOpenid();
    }
}
