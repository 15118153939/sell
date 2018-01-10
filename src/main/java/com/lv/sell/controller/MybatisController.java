package com.lv.sell.controller;

import com.lv.sell.dataobject.ProductCategory;
import com.lv.sell.dataobject.mapper.ProductCategoryMapper;
import com.lv.sell.utils.ResultVOUtil;
import com.lv.sell.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2018/1/10 8:11
 * @Description
 **/
@RestController
@RequestMapping("/mybatis")
public class MybatisController {

    @Autowired
    private ProductCategoryMapper mapper;

    /***
     * 简单测试使用mybatis来实现
     * @return
     */
    @GetMapping("/list")
    public ResultVO list() {
        List<ProductCategory> categoryList = mapper.findAll();

        return ResultVOUtil.success(categoryList);
    }


}
