package com.lv.sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/29 18:49
 * @Description
 **/
@Controller
@Slf4j
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/demo")
    public String freemarker(Map<String, Object> map) {
        map.put("descrip", "It's a springboot integrate freemarker's demo!!!!");
        return "/pay/demo";
    }

    @RequestMapping("/demo2")
    public ModelAndView demo2(){


        ModelAndView mv = new ModelAndView();
        mv.addObject("descrip", "It's a springboot integrate freemarker's demo!!!!");

//        mv.setView("/pay/demo");
        mv.setViewName("/pay/demo");
        return  mv;

    }

    @RequestMapping("/demo3")
    public ModelAndView demo3(){
        ModelAndView mv = new ModelAndView("pay/create");
        mv.addObject("name","我日你现任");
        return mv;
    }

}
