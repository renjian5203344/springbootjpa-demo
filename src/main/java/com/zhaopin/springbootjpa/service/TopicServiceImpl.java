package com.zhaopin.springbootjpa.service;

import com.zhaopin.springbootjpa.dataobject.Article;
import com.zhaopin.springbootjpa.dataobject.Toppic;
import com.zhaopin.springbootjpa.repository.ArticleRepository;
import com.zhaopin.springbootjpa.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TopicServiceImpl implements TopicService{

    @Autowired  //注入DAO
    private TopicRepository topicRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Transactional
    @Override
    public Toppic saveTopic(Toppic toppic) {
        return topicRepository.save(toppic);
    }
    @Transactional
    @Override
    public Toppic updateTopic(Toppic toppic) {

        return topicRepository.save(toppic);
    }
    @Transactional
    @Override
    public Toppic findTopic(Long id) {
        return topicRepository.findById(id).get();
    }
    @Transactional
    @Override
    public Toppic incioudArticle(Long topicId, Long articleId) {

        Toppic toppic = topicRepository.findById(topicId).get();//获取专题
        Article article = articleRepository.findById(articleId).get();//获取文航
        //设置关系
        toppic.getArticles().add(article);//把当前文航对象设置topic实体对象里面来
        return topicRepository.save(toppic);
    }
    @Transactional
    @Override
    public Toppic unIncioudArticle(Long topicId, Long articleId) {

        Toppic toppic = topicRepository.findById(topicId).get();
        Article article = articleRepository.findById(articleId).get();
        toppic.getArticles().remove(toppic);
        return topicRepository.save(toppic);
    }

    @Override
    public void deleteTopic(Long id) {

    topicRepository.deleteById(id);

    }
}
