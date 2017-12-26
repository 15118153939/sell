package com.lv.sell.dto;

import com.lv.sell.dataobject.OrderDetail;
import com.lv.sell.enums.OrderStatusEnum;
import com.lv.sell.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/25 19:46
 * @Description
 * 数据传输对象DTO
 **/

@Data
public class OrderDTO {

    /***
     * 订单ID
     */
    private String orderId;

    /***
     * 买家姓名
     */
    private String buyerName;

    /***
     * 买家手机号
     */
    private String buyerPhone;

    /**
     * 买家地址
     */
    private String buyerAddress;

    /***
     * 卖家微信（OpenId）
     */
    private String buyerOpenid;

    /***
     * 订单总金额
     */
    private BigDecimal orderAmount;
    /**
     * 订单状态：默认是0 新下单
     */
    private Integer orderStatus;

    /**
     * 支付状态：默认0，等待支付
     */
    private Integer payStatu;

    /***
     * 等待时间
     */
    private Date createTime;
    /***
     * 更新时间
     */
    private Date updateTime;


    List<OrderDetail> orderDetailList;

}
