package com.lv.sell.utils;

import com.lv.sell.enums.CodeEnum;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2018/1/6 9:01
 * @Description
 **/
public class EnumUtil {
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each: enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
