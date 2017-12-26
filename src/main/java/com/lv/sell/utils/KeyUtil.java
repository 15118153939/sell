package com.lv.sell.utils;

import java.util.Random;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/25 20:24
 * @Description
 **/
public class KeyUtil {
    /***
     * 生成唯一主键
     * 格式：时间+随机数
     * @return
     * 防止高并发下重复
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();
//        生成6位随机数
        Integer a = random.nextInt(900000)+100000;
        return  System.currentTimeMillis() + String.valueOf(a);
    }
}
