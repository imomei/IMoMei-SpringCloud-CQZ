package com.imomei.common.res;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/***
 * 全局统一返回JSON数据样式
 */

@Data // Get&Set
@NoArgsConstructor // 空参
@AllArgsConstructor // 全参
public class IMoMeiResult implements Serializable {

    // 返回状态码
    private Integer code;
    // 返回信息
    private String msg;
    // 返回数据
    private Object data;
    // 总记录数
    private String total;

    public IMoMeiResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
        this.total = null;
    }

}
