package com.util;

import java.util.UUID;

/**
 * 村口儿王富贵
 * 2020/12/23 0023
 */
public class UUIDGenerator {
    /**
     * @return 一个32个字节的随机字符串,具有唯一性;
     */
    public static String generate(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
