package com.ZIBShopping.enums;

public enum OrderType {
    AWAIT_ORDERS("待发货"),
    AWAIT_GOODS("待收货"),
    FINISH("已完成");
    private final String name;

    private OrderType(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
}