package com.zhaopin.springbootjpa;


import com.zhaopin.springbootjpa.dataobject.Article;

public interface ArticleService {

    Article saveArticle(Article article);

    Article updateArticle(Article article);

    Article findArticle(Long id);

    void deleteArticle(Long id);



}
