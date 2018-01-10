package com.lv.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 卖家实体类
 *
 * @Author lvmingliang_glut@163.com
 * @Date 2018/1/9 13:03
 * @Description
 **/
@Data
@Entity

public class SellerInfo implements Serializable {


    private static final long serialVersionUID = 5921739418252792191L;
    @Id
    private String id;

    private String username;

    private String password;

    private String openid;
}
