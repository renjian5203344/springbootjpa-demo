package com.zhaopin.springbootjpa.service;


import com.zhaopin.springbootjpa.dataobject.Article;
import com.zhaopin.springbootjpa.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service//组件扫描的时候可以扫描到
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    @Override
    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article updateArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article findArticle(Long id) {

        return articleRepository.findById(id).get();
    }

    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);

    }
}
