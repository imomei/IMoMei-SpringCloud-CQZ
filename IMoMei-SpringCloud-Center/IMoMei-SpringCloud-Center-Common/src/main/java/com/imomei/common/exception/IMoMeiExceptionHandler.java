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
@RestController
public class IMoMeiExceptionHandler implements ErrorController {

    /**
     * 拦截不可预期异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public IMoMeiResult exception(Exception e) {
        System.out.println(e.getMessage());
        System.out.println(e.getLocalizedMessage());
        return new IMoMeiResult().ERROR(IMoMeiResultCode.SERVER_ERROR, "系统异常");
    }

    /**
     * 拦截自定义异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = IMoMeiException.class)
    public IMoMeiResult iMoMeiException(IMoMeiException e) {
        return new IMoMeiResult().ERROR(e.getCode(), e.getMsg());
    }


    /**
     * 错误请求URL
     *
     * @return
     */
    @Override
    public String getErrorPath() {
        return "/error";
    }

    /**
     * 接收错误请求
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/error", produces = {"application/json"})
    public IMoMeiResult error(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        return new IMoMeiResult().ERROR(statusCode, "请求异常");
    }

}
