package com.ZIBShopping.enums;

public enum OrderType {
    AWAIT_PAY("待付款"),
    AWAIT_SEND("待发货"),
    AWAIT_RECEIVE("待收货"),
    AWAIT_REMARK("待评价"),
    CLOSE("取消"),
    FINISH("已完成");
    private final String name;

    private OrderType(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
}