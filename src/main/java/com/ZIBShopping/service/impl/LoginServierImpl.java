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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class LoginServierImpl implements LoginService {

    @Autowired
    private WeixiConfig config;
    @Autowired
    private RedisTemplate<String, String> redis;
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;


    @Override
    public ResultInfo getToken(Map<String, Object> userInfo) {

        Map<String, String> map = new HashMap<>();
        boolean flag = false;
        map.put(Constants.APPID, config.getAppid());
        map.put(Constants.APPSECRET, config.getAppsecret());
        map.put(Constants.JS_CODE, (String)userInfo.get("code"));
        map.put(Constants.GRANT_TYPE, config.getGrant_type());

        ResultInfo resultInfo = HttpUtils.sendPost(config.getAppurl(), map);
        if (resultInfo.code < 1) {

            return resultInfo;
        }
        //获取返回信息
        JSONObject json = JSONObject.parseObject((String) resultInfo.obj);
        String openid = json.getString(Constants.OPENID);
        String old_token = redis.opsForValue().get(openid);
        if (old_token != null) {
            redis.delete(old_token);
        }

        String token = UUID.randomUUID().toString();
        redis.opsForValue().set(openid, token);

        //存入用户信息
        UserDto userDto = userDao.findUserDtoByOpenid(openid);
        if (userDto == null) {
            userInfo.put(Constants.OPENID,openid);
            resultInfo = userService.save(userInfo);
            if (resultInfo.code < 1) {

                return resultInfo;
            }
        }
        //存入缓存
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put(Constants.UID, String.valueOf(userDto == null ? resultInfo.obj:userDto.getId()));
        tokenMap.put(Constants.OPENID, json.getString(Constants.OPENID));
        tokenMap.put(Constants.SESSION_KEY, json.getString(Constants.SESSION_KEY));
        redis.opsForHash().putAll(token, tokenMap);

        resultInfo.code = 1;
        resultInfo.msg = "获取token成功";
        resultInfo.obj = token;

        return resultInfo;
    }
}
