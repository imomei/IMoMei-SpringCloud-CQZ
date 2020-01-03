package com.imomei.dao;

import com.imomei.Entity.ArticleESEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleDao extends ElasticsearchRepository<ArticleESEntity, String> {
}
