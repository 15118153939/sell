package com.lv.sell.vo;

import lombok.Data;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/22 10:33
 * @Description
 * http请求返回的最外层对象
 **/
@Data
public class ResultVO<T> {
    /***错误码*/
    private Integer code;
    /***提示信息*/
    private String msg;
    /**具体类容**/
    private T data;
}
