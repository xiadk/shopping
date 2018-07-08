package com.ZIBShopping.common;

import java.util.HashMap;
import java.util.Map;

public class ResultInfo {
    public int code;
    public String msg = "服务器错误";
    public Object obj;

    @Override
    public String toString() {
        return "ResultInfo{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", obj=" + obj +
                '}';
    }

    public Map<String,Object> toMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("code",code);
        map.put("msg",msg);
        map.put("obj",obj);

        return map;
    }
}
