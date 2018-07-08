package com.ZIBShopping.enums;

public enum Introduce {
    GOODS_INTR("产品介绍"),
    COMPANY_INTR("公司介绍"),
    VIEWGAGER_IMG("轮播图"),
    VIEWGAGER_VIDEO("轮播视频");
    private final String name;

    private Introduce(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
}