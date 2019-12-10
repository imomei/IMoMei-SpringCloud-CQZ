package com.imomei.common.res;

import java.io.Serializable;

/**
 * 全局统一状态码枚举类
 */
public class IMoMeiResultCode implements Serializable {

    // 基本状态码
    public static final Integer SUCCESS = 20000;// 成功
    public static final Integer ERROR = 20001;// 失败

    // 上传服务异常：30100-30200
    public final static Integer UPLOAD_UPLOADFILE_ERROR = 30101;// 文件上传失败
    public final static Integer UPLOAD_FILETYPE_ERROR = 30102;// 文件类型错误
    public final static Integer UPLOAD_FILESTREAM_ERROR = 30103;// 文件流错误

    // 注册服务异常：30200-30300
    public final static Integer REGISTER_CHECKTYPE_ERROR = 30201;// 校验类型错误

    // 系统异常
    public static final Integer SERVER_ERROR = 99999;// 服务器异常
}
