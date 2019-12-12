package com.imomei.dao;

import com.imomei.Entity.ArticleESEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticleDao extends ElasticsearchRepository<ArticleESEntity, String> {
}
