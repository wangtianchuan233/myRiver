package com.util;

import java.util.regex.Pattern;

/**
 * 村口儿王富贵
 * 2020/12/23 0023
 */
public class Checker {
    /**
     * 检查手机号
     */
    public static boolean checkMobilePhone(String mp){
        return Pattern.matches("^1[0-9]{10}$",mp);
    }
    /**
     * 检查电话号
     */
    public static boolean checkPhone(String p){
        return Pattern.matches("^(\\((\\d{3,4}-)|(\\d{3,4}-)?)\\d{7,8}$",p);
    }
    /**
     * 检查邮箱
     */
    public static boolean checkMail(String mail){
        return Pattern.matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$",mail);
    }

}
