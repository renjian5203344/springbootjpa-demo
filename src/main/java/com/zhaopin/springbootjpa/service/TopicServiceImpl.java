package com.zhaopin.springbootjpa.service;

import com.alibaba.fastjson.JSON;
import com.zhaopin.springbootjpa.dataobject.Article;
import com.zhaopin.springbootjpa.dataobject.Topic;
import com.zhaopin.springbootjpa.repository.ArticleRepository;
import com.zhaopin.springbootjpa.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopicServiceImpl  implements TopicService {

    @Autowired  //注入DAO
    private TopicRepository topicRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Transactional
    @Override
    public Topic saveTopic(Topic topic) {
        return topicRepository.save(topic);
    }
    @Transactional
    @Override
    public Topic updateTopic(Topic topic) {

        return topicRepository.save(topic);
    }
    @Transactional
    @Override
    public Topic findTopic(Long id) {
        Topic topic = topicRepository.findById(id).get();
        System.out.println(JSON.toJSONString(topic,true));
        return topic;


    }
    @Transactional
    @Override
    public Topic incioudArticle(Long topicId, Long articleId) {

        Topic topic = topicRepository.findById(topicId).get();//获取专题
        Article article = articleRepository.findById(articleId).get();//获取文航
        //设置关系
        topic.getArticles().add(article);//把当前文章对象设置topic实体对象里面来
        //放在事务里面，就不需要去做save,为什么呢，开启一个事务，到这个结束之后，它就会事务提交。改变之后在session提交之后，直接进行数据库同步去更新。
        //前提是一定要设置在session里面
        // return topicRepository.save(toppic);
        return topic;
    }

    @Transactional
    @Override
    public Topic unIncioudArticle(Long topicId, Long articleId) {

        Topic topic =  topicRepository.findById(topicId).get();
        Article article = articleRepository.findById(articleId).get();
        topic.getArticles().remove(article);
        return  topic;
    }

    @Override
    public void deleteTopic(Long id) {

        topicRepository.deleteById(id);

    }
}
