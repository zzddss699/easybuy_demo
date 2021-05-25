package com.zds.easybuy_demo.enumException;

/**
 * @ClassName CustomServiceException
 * @Description TODO
 * @Author 157
 * @Date 2021/4/27 12:45
 * @Version 1.0
 **/
public class CustomServiceException extends RuntimeException{

    private Integer code;
    private String msg;

    public CustomServiceException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
