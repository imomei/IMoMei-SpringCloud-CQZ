package com.imomei.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * 全局异常类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IMoMeiException extends RuntimeException {

    // 异常状态码
    private Integer code;
    // 异常信息
    private String msg;

}
