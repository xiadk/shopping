package com.ZIBShopping.utils;

import java.util.Date;

public class OrderNumberUtils {
    public static String getOrderNum(Long userId,Date data,String proId){
        if(proId==null){
            proId = "";
        }
        String orderNum = userId+""+data.getTime()+proId;
        return orderNum;
    }
}
