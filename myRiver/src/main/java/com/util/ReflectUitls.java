package com.util;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 村口儿王富贵
 * 2020/12/23 0023
 */
public class ReflectUitls {
    /**
     * 寻找 obj 和 target 的同名属性,
     * 把 obj 的属性的值赋值给 target 的同名属性;
     */
    public static void copyFieldsFromObject(Object obj, Object target){
        Class clazz2 = target.getClass();
        Field[] declaredFields = clazz2.getDeclaredFields();
        for (Field targetField : declaredFields) {
            String name = targetField.getName();
            Field oldField = null;
            try {
                oldField = obj.getClass().getDeclaredField(name);
                targetField.setAccessible(true);
                oldField.setAccessible(true);
                targetField.set(target, oldField.get(obj));
            } catch (NoSuchFieldException e) {
                String msg = e.getMessage();
                // 日志处理
            } catch (IllegalAccessException e) {
                String msg = e.getMessage();
                // 日志处理
            }
        }
    }
    /**
     * 寻找与 map 的 key 同名的 target 的属性,
     * 把 key 对应的 value 值赋值给 target 的同名属性;
     */
    public static void copyFieldsFromMap(Map<String,Object> map,Object target){
        Class clazz2 = target.getClass();
        Field[] declaredFields = clazz2.getDeclaredFields();
        for (Field targetField : declaredFields) {
            String name = targetField.getName();
            System.out.print("key ---> " + name);
            try {
                targetField.setAccessible(true);
                System.out.println(", value ---> " + map.get(name));
                targetField.set(target, map.get(name));
            } catch (IllegalAccessException e) {
                String msg = e.getMessage();
                // 日志处理
            }
        }
    }
}
