package com.imomei.common.res;

import java.io.Serializable;

/**
 * 全局统一状态码枚举类
 */
public class IMoMeiResultCode implements Serializable {

    // 基本状态码
    public static final Integer SUCCESS = 20000;
    public static final String SUCCESS_STRING = "操作成功";
    public static final Integer ERROR = 20001;
    public static final String ERROR_STRING = "操作失败";
    public static final Integer MISSING_PARAM = 20002;
    public static final String MISSING_PARAM_STRING = "缺失必要参数";
    public static final Integer PAGE_ERROR = 20003;
    public static final String PAGE_ERROR_STRING = "分页参数异常";
    public static final Integer UPDATE_ERROR = 20004;
    public static final String UPDATE_ERROR_STRING = "更新失败";
    public static final Integer INSERT_ERROR = 20005;
    public static final String INSERT_ERROR_STRING = "插入失败";
    public static final Integer DELETE_ERROR = 20006;
    public static final String DELETE_ERROR_STRING = "删除失败";
    public static final Integer UPLOAD_ERROR = 20007;
    public static final String UPLOAD_ERROR_STRING = "上传失败";

    // 上传服务异常：30100-30200
    public final static Integer UPLOAD_UPLOADFILE_ERROR = 30101;// 文件上传失败
    public final static Integer UPLOAD_FILETYPE_ERROR = 30102;// 文件类型错误
    public final static Integer UPLOAD_FILESTREAM_ERROR = 30103;// 文件流错误

    // 注册服务异常：30200-30300
    public final static Integer REGISTER_CHECKTYPE_ERROR = 30201;// 校验类型错误

    // 系统异常
    public static final Integer SERVER_ERROR = 99999;// 服务器异常
}
