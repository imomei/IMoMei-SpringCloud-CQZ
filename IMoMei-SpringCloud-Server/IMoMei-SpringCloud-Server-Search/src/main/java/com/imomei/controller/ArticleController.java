package com.imomei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @RequestMapping("/search")
    public void search() {
        
    }
}