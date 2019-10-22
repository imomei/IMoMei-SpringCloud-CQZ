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

    /**
     * 成功无数据
     */
    public static IMoMeiResult OK() {
        return new IMoMeiResult(IMoMeiResultCode.SUCCESS, "操作成功", null, null);
    }

    /**
     * 成功有数据
     */
    public static IMoMeiResult OK(Object data) {
        return new IMoMeiResult(IMoMeiResultCode.SUCCESS, "操作成功", data, null);
    }

    /**
     * 快速失败无数据
     */
    public static IMoMeiResult ERROR(int code, String msg) {
        return new IMoMeiResult(code, msg, null, null);
    }

}
