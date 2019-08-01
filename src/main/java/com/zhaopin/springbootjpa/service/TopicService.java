package com.zhaopin.springbootjpa.service;

import com.zhaopin.springbootjpa.dataobject.Toppic;

public interface TopicService {

    Toppic saveTopic(Toppic toppic);

    Toppic updateTopic(Toppic toppic);

    Toppic findTopic(Long id);

    Toppic incioudArticle(Long topicId, Long articleId);//收录文章


    Toppic  unIncioudArticle(Long topicId, Long articleId);//取消收录文章

    void deleteTopic(Long id);








}
