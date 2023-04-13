package com.ebanma.cloud.usertestall.exception;

import com.ebanma.cloud.usertestall.domain.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 黄贵龙
 * @version $ Id: GlobalExceptionHandler, v 0.1 2023/03/19 11:49 86139 Exp $
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public Result businessException(BusinessException e) {
        LOGGER.error("捕捉到业务异常：", e);
        return Result.fail(e);
    }

    @ResponseBody
    @ExceptionHandler(value = RuntimeException.class)
    public Result runtimeExceptionHandler(RuntimeException e){
        LOGGER.error("捕捉到运行时异常：", e);
        return Result.fail(e);
    }

    @ResponseBody
    @ExceptionHandler(value = Throwable.class)
    public Result throwableHandler(Throwable th) {
        LOGGER.error("捕捉到Throwable异常：", th);
        return Result.fail(th);
    }

}
