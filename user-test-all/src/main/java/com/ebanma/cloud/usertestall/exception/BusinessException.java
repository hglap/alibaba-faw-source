package com.ebanma.cloud.usertestall.exception;

import com.ebanma.cloud.usertestall.domain.common.ErrorCode;

/**
 * @author 黄贵龙
 * @version $ Id: BusinessException, v 0.1 2023/03/22 10:51 86139 Exp $
 */
public class BusinessException extends RuntimeException{

    private final String code;


    /**
     * 业务异常
     *
     * @param errorCode 错误代码
     */
    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getDesc());
        this.code = errorCode.getCode();
    }

    /**
     * 业务异常
     *
     * @param errorCode 错误代码
     * @param message   消息
     */
    public BusinessException(ErrorCode errorCode,String message) {
        super(message);
        this.code = errorCode.getCode();
    }

    /**
     * 业务异常
     *
     * @param errorCode 错误代码
     * @param cause     导致
     */
    public BusinessException(ErrorCode errorCode,Throwable cause) {
        super(cause);
        this.code = errorCode.getCode();
    }
}
