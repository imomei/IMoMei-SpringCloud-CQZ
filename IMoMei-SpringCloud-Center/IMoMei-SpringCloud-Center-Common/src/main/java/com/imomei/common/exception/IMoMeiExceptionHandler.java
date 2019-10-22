package com.imomei.common.exception;

import com.imomei.common.res.IMoMeiResult;
import com.imomei.common.res.IMoMeiResultCode;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/***
 * 全局异常拦截类
 */
@RestControllerAdvice
public class IMoMeiExceptionHandler implements ErrorController {

    // 拦截不可预知异常
    @ExceptionHandler(value = Exception.class)
    public IMoMeiResult exception(Exception e) {
        return new IMoMeiResult(IMoMeiResultCode.SERVER_ERROR, "系统异常");
    }

    // 拦截自定义异常
    @ExceptionHandler(value = IMoMeiException.class)
    public IMoMeiResult iMoMeiException(IMoMeiException e) {
        return new IMoMeiResult(e.getCode(), e.getMsg());
    }

    // 错误请求统一转发URL
    @Override
    public String getErrorPath() {
        return "/error";
    }

    // 处理错误请求
    @RequestMapping(value = "/error", produces = {"application/json"})
    public IMoMeiResult error(HttpServletRequest request) {
        // 获取请求状态码：404-500
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        return new IMoMeiResult(statusCode, "系统异常");
    }

}
