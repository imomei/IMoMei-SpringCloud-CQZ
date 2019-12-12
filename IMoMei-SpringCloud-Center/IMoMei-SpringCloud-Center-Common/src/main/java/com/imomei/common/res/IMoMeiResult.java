package com.imomei.common.res;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 全局统一返回实体类
 */

@Data
public class IMoMeiResult implements Serializable {

    // 返回状态码
    private Integer code;
    // 返回信息
    private String msg;
    // 返回数据
    private Object data;
    // 总记录数
    private Long total;
    // 时间
    private String time;

    // 无数据返回（成功或者失败）
    public IMoMeiResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
        this.total = null;
        this.time = getDateNow();
    }

    // 有数据返回
    public IMoMeiResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.total = null;
        this.time = getDateNow();
    }

    // 有数据有总条数返回
    public IMoMeiResult(Integer code, String msg, Object data, Long total) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.total = total;
        this.time = getDateNow();
    }

    public static String getDateNow() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }

}
