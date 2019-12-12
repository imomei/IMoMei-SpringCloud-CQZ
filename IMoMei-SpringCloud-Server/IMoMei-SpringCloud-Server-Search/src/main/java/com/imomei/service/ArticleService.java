package com.imomei.service;

import com.imomei.Entity.ArticleESEntity;
import com.imomei.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;

    //  添加文章
    public void saneArticle(ArticleESEntity articleESEntity) {
        articleDao.save(articleESEntity);
    }
}
