package com.imomei.common.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IMoMeiPageReq {
    private Integer pageNum;
    private Integer pageSize;
}
