package com.lv.sell.utils;

import com.lv.sell.vo.ResultVO;

/**
 * @Author lvmingliang_glut@163.com
 * @Date 2017/12/25 9:58
 * @Description
 **/
public class ResultVOUtil {

    /***
     *
     * @param object
     * @return
     */
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    /**
     *
     * @return
     */
    public static ResultVO success(){
        return success(null);
    }

    /**
     * 错误
     * @param code
     * @param msg
     * @return
     */
    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }

}
