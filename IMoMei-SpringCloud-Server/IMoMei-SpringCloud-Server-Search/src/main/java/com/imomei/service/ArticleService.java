package com.imomei.service;

import com.imomei.Entity.ArticleESEntity;
import com.imomei.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;

    // 查询文章
    public void searchArticle() {
        Iterable<ArticleESEntity> all = articleDao.findAll();
    }

    //  添加文章
    public void saveArticle(ArticleESEntity articleESEntity) {
        ArticleESEntity save = articleDao.save(articleESEntity);
    }

    // 删除文章
    public void delArticle(ArticleESEntity articleESEntity) {
        articleDao.delete(articleESEntity);
    }
}
