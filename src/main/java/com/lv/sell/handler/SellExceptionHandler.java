package com.lv.sell.handler;

import com.lv.sell.config.ProjectUrlConfig;
import com.lv.sell.exception.ResponseBankException;
import com.lv.sell.exception.SellException;
import com.lv.sell.exception.SellerAuthorizeException;
import com.lv.sell.utils.ResultVOUtil;
import com.lv.sell.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2018/1/9 15:27
 * @Description
 **/
@ControllerAdvice
@Slf4j
public class SellExceptionHandler {
    @Autowired
    private ProjectUrlConfig projectUrlConfig;
////    拦截登录异常
//    @ExceptionHandler(value = SellerAuthorizeException.class) //拦截异常的类
//    @ResponseStatus(HttpStatus.FORBIDDEN)
//    public ModelAndView handlerAuthorizeException(){
//
////        String url = "redirect:"+projectUrlConfig.getSell()+"/sell/seller/user/login";
////        String url = "redirect:www.baidu.com";
//        String url = "www.baidu.com";
//        log.info("[登陆url]{}",url);
////        跳转到登录页面
//        return new ModelAndView(url);
//
//
//    }

    //    拦截登录异常
    @ExceptionHandler(value = SellerAuthorizeException.class) //拦截异常的类
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String handlerAuthorizeException(){

//        String url = "redirect:"+projectUrlConfig.getSell()+"/sell/seller/user/login";
//        String url = "redirect:www.baidu.com";
        String url = "www.baidu.com";
        log.info("[登陆url]{}",url);
//        跳转到登录页面
        return "user/login";


    }




    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellerException(SellException e) {

        return ResultVOUtil.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = ResponseBankException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handleResponseBankException() {

    }
}
