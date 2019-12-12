package com.imomei.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(indexName = "imomei", type = "article")
public class ArticleESEntity {

    @Id
    private String articleId;
    @Field(index = true, analyzer = "ik_smart", searchAnalyzer = "ik_max_word")
    private String articleTitle;
    private String articleUrl;
    @Field(index = true, analyzer = "ik_smart", searchAnalyzer = "ik_max_word")
    private String articleDesc;

}
