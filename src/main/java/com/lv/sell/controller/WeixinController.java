package com.lv.sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/28 15:41
 * @Description
 **/
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {

    @GetMapping("/auth")
    public void auth(){
      log.info("进入weixin auth...方法");
    }
}
