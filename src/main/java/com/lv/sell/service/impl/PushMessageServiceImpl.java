package com.lv.sell.service.impl;

import com.lv.sell.config.WechatAccountConfig;
import com.lv.sell.dto.OrderDTO;
import com.lv.sell.service.PushMessageService;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2018/1/9 17:50
 * @Description
 **/
public class PushMessageServiceImpl implements PushMessageService{

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private WechatAccountConfig accountConfig;

    @Override
    public void orderStatus(OrderDTO orderDTO) {
//
//        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
//        templateMessage.setTemplateId(accountConfig.getTemplateId().get("orderStatus"));
//        templateMessage.setToUser(orderDTO.getBuyerOpenid());
//
//        List<WxMpTemplateData> data = Arrays.asList(
//                new WxMpTemplateData("first", "亲，请记得收货。"),
//                new WxMpTemplateData("keyword1", "微信点餐"),
//                new WxMpTemplateData("keyword2", "18868812345"),
//                new WxMpTemplateData("keyword3", orderDTO.getOrderId()),
//                new WxMpTemplateData("keyword4", orderDTO.getOrderStatusEnum().getMessage()),
//                new WxMpTemplateData("keyword5", "￥" + orderDTO.getOrderAmount()),
//                new WxMpTemplateData("remark", "欢迎再次光临！")
//        );
//        templateMessage.setData(data);
//        try {
//            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
//        }catch (WxErrorException e) {
//            log.error("【微信模版消息】发送失败, {}", e);
//        }
    }
}
