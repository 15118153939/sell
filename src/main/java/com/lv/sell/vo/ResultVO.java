package com.lv.sell.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/22 10:33
 * @Description
 * http请求返回的最外层对象
 **/
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)  //如果有熟悉为null,则返回的json去掉此属性吧。
public class ResultVO<T> {
    /***错误码*/
    private Integer code;
    /***提示信息*/
    private String msg =""; //针对字段返回情况，如果没有 可以设置初始值，這样返回到前段就不会是null
    /**具体类容**/
    private T data;
}
