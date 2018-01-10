package com.lv.sell.dataobject;

import com.lv.sell.enums.OrderStatusEnum;
import com.lv.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/25 12:33
 * @Description
 **/
@Entity
@Data
@DynamicUpdate
public class OrderMaster implements Serializable {

    private static final long serialVersionUID = -6221061547706199381L;
    /***
     * 订单ID
     */
    @Id
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
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /**
     * 支付状态：默认0，等待支付
     */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /***
     * 等待时间
     */
    private Date createTime;
    /***
     * 更新时间
     */
    private Date updateTime;


}
