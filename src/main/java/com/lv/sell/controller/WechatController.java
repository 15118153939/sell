package com.lv.sell.controller;


import com.lv.sell.enums.ResultEnum;
import com.lv.sell.exception.SellException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/28 19:07
 * @Description
 **/
//@RestController
@ControllerAdvice
@RequestMapping("/wechat")
@Slf4j
public class WechatController {

    @Autowired
    private WxMpService wxMpService;

    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl") String returnUul) {


//        1:配置
//        2调用方法
//        重定向：到那个url,然后就可以获取openid了
        String url = "http://lvmingliang.nat300.top/sell/wechat/userInfo";
//        wxMpService.oauth2buildAuthorizationUrl(url,WxConsts.OAUTH2_SCOPE_USER_INFO,null);
//        OAUTH2_SCOPE_BASE 就是不用设权弹窗
//        由于WxConsts类重构咯。
//        访问如下：
//        https://github.com/Wechat-Group/weixin-java-tools/commit/2146372502d8c93b72a8e0ef677d6a0620a4a416
        String redirecUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_USERINFO, URLEncoder.encode(returnUul));
        return "redirect:" + redirecUrl;
    }

    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code,
                           @RequestParam("state") String returnUrl) {
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);

        } catch (WxErrorException e) {
            log.error("[微信网页授权]{}", e);
            throw new SellException(ResultEnum.WECHAT_MP_ERROR.getCode(), e.getError().getErrorMsg());
        }
//没问题就拿到openid
        String openid = wxMpOAuth2AccessToken.getOpenId();
        System.out.println(openid);

        return "redirect:" + returnUrl + "?openid=" + openid;
    }

    @GetMapping("/test")
    public void getTest() {
        log.info("---------test----------------");
    }
}
