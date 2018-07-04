package com.ZIBShopping.utils;

/**
 * zjh 2018.7.3
 *
 * sql防注入工具类
 */
public class SqlInjectUtils {
    public static boolean sql_inj(String str) {
        String inj_str = "'|and|exec|insert|select|delete|update|count|*|%|chr|mid|master|truncate|char|declare|;|or|-|+|,|\"";
        String[] inj_strs = inj_str.split("\\|");
        for (int i = 0; i < inj_strs.length; i++) {
            if (str.indexOf(inj_strs[i]) != 0) {
                return true;
            }
        }
        return false;
    }
    public static String transactSQLInjection(String str)
    {
        return str.replaceAll(".*([';]+|(--)+).*", "");
    }
}
