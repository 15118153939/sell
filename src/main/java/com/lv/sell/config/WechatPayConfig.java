package com.lv.sell.config;

import com.lly835.bestpay.config.WxPayH5Config;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import com.lv.sell.config.WechatAccountConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/28 21:05
 * @Description
 **/
public class WechatPayConfig {
    @Autowired
    private WechatAccountConfig accountConfig;

    public BestPayServiceImpl bestPayService() {
        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
        bestPayService.setWxPayH5Config(wxPayH5Config());
        return bestPayService;
    }

    /***
     * ctrl +alt + m 抽取方法
     * @return
     */
    @Bean
    private WxPayH5Config wxPayH5Config() {
        WxPayH5Config wxPayH5Config = new WxPayH5Config();
        wxPayH5Config.setAppId(accountConfig.getMpAppId());
        wxPayH5Config.setAppSecret(accountConfig.getMpAppSecret());
        wxPayH5Config.setMchId(accountConfig.getMchId());
        wxPayH5Config.setMchKey(accountConfig.getMchKey());
        wxPayH5Config.setKeyPath(accountConfig.getKeyPath());
        wxPayH5Config.setNotifyUrl(accountConfig.getNotifyUrl());
        return wxPayH5Config;
    }


}
