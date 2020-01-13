package com.imomei.controller;

import com.imomei.common.constant.IMoMeiConstant;
import com.imomei.common.exception.IMoMeiException;
import com.imomei.common.res.IMoMeiResult;
import com.imomei.common.res.IMoMeiResultCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

@RestController
public class UploadController {

    @Value("${imomei.upload.prefix}")
    private String FILE_UPLOAD_PREFIX;

    @RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
    public IMoMeiResult uploadImg(MultipartFile file) {
        try {
            // 获取文件名称
            String originalFileName = file.getOriginalFilename();
            // 获取文件后缀名
            String fileNameSuffix = originalFileName.substring(originalFileName.lastIndexOf("."));
            // 生成ID
            String uuid = UUID.randomUUID().toString();
            // 文件保存路径
            String filePath = FILE_UPLOAD_PREFIX + uuid + fileNameSuffix;
            // 创建File类
            File saveFile = new File(filePath);
            // 保存文件
            file.transferTo(saveFile);
            // 数据落库
            return new IMoMeiResult(IMoMeiResultCode.SUCCESS, IMoMeiResultCode.SUCCESS_STRING, uuid + fileNameSuffix);
        } catch (Exception e) {
            throw new IMoMeiException(IMoMeiResultCode.UPLOAD_ERROR, IMoMeiResultCode.UPLOAD_ERROR_STRING);
        }
    }

}
