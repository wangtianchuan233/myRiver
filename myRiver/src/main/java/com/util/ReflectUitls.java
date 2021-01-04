package com.util;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
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
    public static void copyFieldsFromMap(Map map,Object target){
        Class clazz2 = target.getClass();
        Field[] declaredFields = clazz2.getDeclaredFields();
        for (Field targetField : declaredFields) {
            String name = targetField.getName();
            //System.out.print("key ---> " + name);
            try {
                targetField.setAccessible(true);
                //System.out.println(", value ---> " + map.get(name));
                Object val = map.get(name);
                if (val != null) {
                    String value = val.toString();
                    String targetClazz = targetField.getType().getSimpleName();
                    if ("Integer".equals(targetClazz)){
                        Integer v = Integer.valueOf(value) ;
                        targetField.set(target, v);
                    }else if ("Double".equals(targetClazz)){
                        Double v = Double.valueOf(value) ;
                        targetField.set(target, v);
                    }else if ("int".equals(targetClazz)){
                        int v = Integer.parseInt(value) ;
                        targetField.set(target, v);
                    }else if ("double".equals(targetClazz)){
                        double v = Double.parseDouble(value) ;
                        targetField.set(target, v);
                    }else if ("String".equals(targetClazz)){
                        targetField.set(target, value);
                    }else if ("BigDecimal".equals(targetClazz)){
                        BigDecimal v = new BigDecimal(value);
                        targetField.set(target, v);
                    }else if ("BigInteger".equals(targetClazz)){
                        BigInteger v = new BigInteger(value);
                        targetField.set(target, v);
                    }else if ("boolean".equals(targetClazz)){
                        boolean v = Boolean.parseBoolean(value) ;
                        targetField.set(target, v);
                    }else if ("Boolean".equals(targetClazz)){
                        Boolean v = Boolean.valueOf(value) ;
                        targetField.set(target, v);
                    }else if ("long".equals(targetClazz)){
                        long v = Long.parseLong(value) ;
                        targetField.set(target, v);
                    }else if ("Long".equals(targetClazz)){
                        Long v = Long.valueOf(value) ;
                        targetField.set(target, v);
                    }
                }
            } catch (IllegalAccessException e) {
                String msg = e.getMessage();
                // 日志处理
            }
        }
    }
}
