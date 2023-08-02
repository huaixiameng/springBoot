package com.study.exception;


/**
 * 自定义业务异常
 * @author shengwu ni
 */
public class ErrorException extends RuntimeException {

    private static final long serialVersionUID = -7480022450501760611L;

    /**
     * 异常码
     */
    private final String code;
    /**
     * 异常提示信息
     */
    private final String message;

    public ErrorException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public ErrorException(CodeEnum code) {
        this.code = code.getCode();
        this.message = code.getMsg();
    }


    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}