package com.token.jwt.config;

import com.token.jwt.vo.Result;
import com.token.jwt.vo.ResultCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author haort
 * @date 2018/3/4
 */

@ControllerAdvice
@ResponseBody
public class ExceptionHandlerAdvice {
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result handleMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return Result.failure(ResultCode.METHOD_NOT_ALLOWED);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public Result handle404Exception(NoHandlerFoundException e) {
        return Result.failure(ResultCode.NOT_FOUND);
    }

    @ExceptionHandler(MissingServletRequestPartException.class)
    public Result handleMissingServletRequestPartException(MissingServletRequestPartException e) {
        e.printStackTrace();
        return Result.failure(ResultCode.PARAM_NOT_COMPLETE);
    }

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        e.printStackTrace();
        return Result.failure(ResultCode.SYSTEM_ERROR);
    }
}
