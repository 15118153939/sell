package com.lv.sell.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/29 9:53
 * @Description
 * Json格式化的一个工具
 **/
public class JsonUtil {
    public static String toJson(Object object){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);

    }
}
