package com.lv.sell.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/29 11:00
 * @Description
 **/

@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    //    拦截所有
    @Pointcut("execution(public * com.lv.sell.controller.*.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
//        logger.info("---");

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
//        url
        logger.info("url={}", request.getRequestURL());
//        method
        logger.info("method={}", request.getMethod());
//        ip
        logger.info("ip={}", request.getRemoteAddr());
//        path
        logger.info("path={}", request.getServletPath());
        logger.info("LocalAddr={}", request.getLocalAddr());
//        类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//    参数
        logger.info("args={}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter() {

    }

    /**
     * 返回对象
     *
     * @param object
     */
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object != null ? object.toString() : object);
    }
}
