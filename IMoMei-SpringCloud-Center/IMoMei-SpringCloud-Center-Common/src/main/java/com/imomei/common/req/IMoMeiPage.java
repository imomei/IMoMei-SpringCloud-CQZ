package com.imomei.common.req;

import lombok.Data;

import java.io.Serializable;

/***
 * 全局分页请求参数
 */
@Data
public class IMoMeiPage implements Serializable {

    // 当前页数
    private Integer pageNum;
    // 每页记录数
    private Integer pageSize;

}
