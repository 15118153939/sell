package com.lv.sell.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lv.sell.dataobject.OrderDetail;
import com.lv.sell.enums.OrderStatusEnum;
import com.lv.sell.enums.PayStatusEnum;
import com.lv.sell.utils.EnumUtil;
import com.lv.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;
import org.apache.commons.lang3.EnumUtils;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/25 19:46
 * @Description 数据传输对象DTO
 **/

@Data
//@JsonSerialize include = JsonSerialize.Inclusion.NON_NULL
//@JsonInclude(JsonInclude.Include.NON_NULL)  //如果有熟悉为null,则返回的json去掉此属性吧。
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
    private Integer payStatus;

    /***
     * 创建时间
     */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;
    /***
     * 更新时间
     */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;


    List<OrderDetail> orderDetailList = new ArrayList<>();

    /**
     * 获取枚举
     * @return
     */
    @JsonIgnore //转json时忽略此方法
    public OrderStatusEnum getOrderStatusEnum(){
        return OrderStatusEnum.getOrderStatusEnum(this.orderStatus);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus,PayStatusEnum.class);
    }

}
