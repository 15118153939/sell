package com.lv.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 卖家实体类
 * @Author lvmingliang_glut@163.com
 * @Date 2018/1/9 13:03
 * @Description
 **/
@Data
@Entity

public class SellerInfo {

    @Id
    private String id;

    private String username;

    private String password;

    private String openid;
}
