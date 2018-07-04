package com.ZIBShopping.utils;

import org.assertj.core.util.Lists;

import java.util.List;

public class ImgUrlUtils {
    public static List<String> analysis(String imgUrl, String way) {
        String[] imgs = imgUrl.split(way);
        List<String> imgAnalysis = Lists.newArrayList();
        for (String img : imgs) {
            imgAnalysis.add(img);
        }
        return imgAnalysis;
    }
}
