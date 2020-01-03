package com.imomei.controller;

import com.imomei.Entity.ArticleESEntity;
import com.imomei.common.res.IMoMeiResult;
import com.imomei.common.res.IMoMeiResultCode;
import com.imomei.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    // 通过关键字分词搜索
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public IMoMeiResult search(String key) {
        //elasticsearchTemplate.query();
        return new IMoMeiResult(IMoMeiResultCode.SUCCESS, IMoMeiResultCode.SUCCESS_STRING);
    }

    // 插入
    @RequestMapping(value = "/saveArticle", method = RequestMethod.POST)
    public IMoMeiResult saveArticle(@RequestBody ArticleESEntity articleESEntity) {
        articleService.saveArticle(articleESEntity);
        return new IMoMeiResult(IMoMeiResultCode.SUCCESS, IMoMeiResultCode.SUCCESS_STRING);
    }

    // 删除
    @RequestMapping(value = "/delArticle", method = RequestMethod.POST)
    public IMoMeiResult delArticle(@RequestBody ArticleESEntity articleESEntity) {
        articleService.delArticle(articleESEntity);
        return new IMoMeiResult(IMoMeiResultCode.SUCCESS, IMoMeiResultCode.SUCCESS_STRING);
    }

    // 查询所有记录
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public IMoMeiResult getAll(String key) {
        //elasticsearchTemplate.query();
        return new IMoMeiResult(IMoMeiResultCode.SUCCESS, IMoMeiResultCode.SUCCESS_STRING);
    }


}