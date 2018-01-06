package com.lv.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 微信账号相关
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/28 19:16
 * @Description
 **/
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {
    /**
    *appid
    **/
    private String mpAppId;

    /**
    *secret
    **/
    private String mpAppSecret;


    /**
    *商户号
    **/
    private String mchId;

    /**
    *商户密钥
    **/
    private String mchKey;

    /**
    *商户证书路径
    **/
    private String keyPath;

    /**
    *微信支付异步通知
    **/
    private String notifyUrl;
    
    









}
