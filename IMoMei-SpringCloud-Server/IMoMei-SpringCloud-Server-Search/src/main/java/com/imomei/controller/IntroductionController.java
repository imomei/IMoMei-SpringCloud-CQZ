package com.imomei.controller;

import com.imomei.common.res.IMoMeiResult;
import com.imomei.common.res.IMoMeiResultCode;
import com.imomei.entity.IntroductionEntity;
import com.imomei.mapper.IntroductionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/***
 * Introduction的增删改查
 */
@RestController
public class IntroductionController {

    @Autowired
    private IntroductionMapper introductionMapper;

    @RequestMapping(value = "/getIntroductionList")
    public IMoMeiResult getIntroductionList() {
        List<IntroductionEntity> introductionEntitys = introductionMapper.getIntroductionList();
        return new IMoMeiResult(IMoMeiResultCode.SUCCESS, "查询成功", introductionEntitys);
    }

    @RequestMapping(value = "/getIntroductionById")
    public IMoMeiResult getIntroductionById(@RequestParam String id) {
        IntroductionEntity introductionEntity = introductionMapper.getIntroductionById(id);
        return new IMoMeiResult(IMoMeiResultCode.SUCCESS, "查询成功", introductionEntity);
    }

    @RequestMapping(value = "/updIntroduction")
    public String updIntroduction(IntroductionEntity introductionEntity) {
        int count = introductionMapper.updIntroduction(introductionEntity);
        return "更新成功";
    }

    @RequestMapping(value = "/insIntroduction")
    public String insIntroduction(IntroductionEntity introductionEntity) {
        int count = introductionMapper.insIntroduction(introductionEntity);
        return "添加成功";
    }

    @RequestMapping(value = "/delIntroduction")
    public String delIntroduction(@RequestParam String id) {
        int count = introductionMapper.delIntroduction(id);
        return "删除成功";
    }
}
