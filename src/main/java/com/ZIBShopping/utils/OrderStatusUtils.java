package com.ZIBShopping.utils;

import com.ZIBShopping.enums.OrderType;

public class OrderStatusUtils {
    public static Long getStatus(OrderType status){
        Long val = 0l;
        switch (status){
            case AWAIT_PAY:
                val = 0l;
                break;
            case AWAIT_SEND:
                val = 1l;
                break;
            case AWAIT_RECEIVE:
                val = 2l;
                break;
            case AWAIT_REMARK:
                val = 3l;
                break;
            case FINISH:
                val = 4l;
                break;
            case CLOSE:
                val = 5l;
                break;
            default:
                break;
        }
        return val;
    }
}
