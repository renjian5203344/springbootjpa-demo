package com.zhaopin.springbootjpa.service;


import com.zhaopin.springbootjpa.dataobject.Topic;

public interface TopicService {

    Topic saveTopic(Topic topic);

    Topic updateTopic(Topic topic);

    Topic findTopic(Long id);

    Topic incioudArticle(Long topicId, Long articleId);//收录文章


    Topic  unIncioudArticle(Long topicId, Long articleId);//取消收录文章

    void deleteTopic(Long id);








}
