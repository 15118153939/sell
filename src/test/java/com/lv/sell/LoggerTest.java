package com.lv.sell;



import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/20 16:33
 * @Description
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {
//    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);


    @Test
    public void test1(){
//        默认输出级别：info,    ERROR(40, "ERROR"),
//                  WARN(30, "WARN"),
//                INFO(20, "INFO"),
//                DEBUG(10, "DEBUG"),
//                TRACE(0, "TRACE");
//        ctrl +N
//        logger.debug("debug..");
//        logger.info("info..");
//        logger.error("error...");
      //使用lombok需要安装一个插件
         log.debug("debug..");
        log.info("info..");
        log.error("error...");
//        拼接变量
        String name ="lv";
        String password ="123456";
//{}表示占位符号
        log.info("name:{},password:{}",name,password);

    }

}
