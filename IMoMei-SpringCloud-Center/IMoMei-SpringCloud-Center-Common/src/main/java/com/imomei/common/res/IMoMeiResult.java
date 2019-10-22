package com.imomei.common.res;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/***
 * 全局统一返回JSON数据样式
 */

@Data // Get&Set
public class IMoMeiResult implements Serializable {

    // 返回状态码
    private Integer code;
    // 返回信息
    private String msg;
    // 返回数据
    private Object data;
    // 总记录数
    private String total;

    // 无数据返回
    public IMoMeiResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
        this.total = null;
    }

    // 有数据返回
    public IMoMeiResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.total = null;
    }

    // 有数据有总条数返回
    public IMoMeiResult(Integer code, String msg, Object data, String total) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.total = total;
    }

}
