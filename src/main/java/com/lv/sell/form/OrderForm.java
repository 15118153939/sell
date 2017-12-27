package com.lv.sell.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/27 15:31
 * @Description form 包下全用来表单验证的
 **/
@Data
public class OrderForm {
    /**
     * 姓名
     */
    @NotEmpty(message = "姓名必填")
    private String name;

    /**
     * 买家手机号
     **/
    @NotEmpty(message = "手机号必填")
    private String phone;

    /**
     * 买家地址
     **/
    @NotEmpty(message = "地址比填")
    private String address;
    
    /**
    *openid
    **/
    @NotEmpty(message = "openid必填")
    private String openid;

    /**
    *购物车,items
    **/
    @NotEmpty(message = "购物车不能为空")
    private String items ;



    
    


}
