package com.util;

import java.lang.reflect.Field;

/**
 * 村口儿王富贵
 * 2020/12/23 0023
 */
public class ReflectUitls {
    /**
     * 寻找 obj 和 target 的同名属性,
     * 把 obj 的属性的值赋值给 target 的同名属性;
     */
    public static void copyFields(Object obj, Object target){
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
                //e.printStackTrace();
            } catch (IllegalAccessException e) {
                //e.printStackTrace();
            }
        }
    }
}
