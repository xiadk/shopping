package com.ZIBShopping;

import com.ZIBShopping.common.Constants;
import com.ZIBShopping.common.WeixiConfig;
import com.ZIBShopping.utils.HttpUtils;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZbApplicationTests {

    @Autowired
    private WeixiConfig weixiConfig;

    @Autowired
    private RedisTemplate<String, ?> redis;
    private JSONObject json = new JSONObject();

    @Test
    public void contextLoads() {
//        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
//        valueOperations.set("hello", "redis");
//        System.out.println("useRedisDao = " + valueOperations.get("hello"));
        Map<String,String> map = new HashMap<>();
         map.put(Constants.APPID,"1");
         map.put(Constants.APPSECRET,"2");
         map.put(Constants.JS_CODE,"3");
         map.put(Constants.GRANT_TYPE,"4");
        redis.opsForHash().putAll("test", map);
        List<Object> keys = new ArrayList<Object>();
        keys.add(Constants.APPID);
        keys.add(Constants.APPSECRET);
        keys.add(Constants.JS_CODE);
        System.out.println(redis.opsForHash().multiGet("test",keys));


    }

     @Test
    public void test() {
         /*Map<String,String> map = new HashMap<>();
         map.put("appid",weixiConfig.getAppid());
         map.put("secret",weixiConfig.getAppsecret());
         map.put("js_code","033ZmNKk0Xrkql1b30Nk0MuKKk0ZmNKv");
         map.put("grant_type","authorization_code");


         String result = HttpUtils.sendPost(weixiConfig.getAppurl(),map);
         System.out.println(result);*/
    }

}
