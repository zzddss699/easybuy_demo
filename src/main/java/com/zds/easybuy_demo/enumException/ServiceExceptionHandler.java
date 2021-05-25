package com.zds.easybuy_demo.enumException;

import com.zds.easybuy_demo.baseDao.RespBean;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName ServiceExceptionHandler
 * @Description TODO
 * @Author 157
 * @Date 2021/4/27 12:48
 * @Version 1.0
 **/
@ControllerAdvice
public class ServiceExceptionHandler {
    /**
     * 可以处理所有Controller中抛出的CustomServiceException的异常
     * @param e
     * @return
     */
    @ExceptionHandler(CustomServiceException.class)
    @ResponseBody
    public RespBean serviceHandler(CustomServiceException e){
         RespBean respBean ;
         return new RespBean();
    }
}
