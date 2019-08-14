package com.zhaopin.springbootjpa.service;

import com.alibaba.fastjson.JSON;

import com.zhaopin.springbootjpa.dataobject.Topic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicServiceImplTest {
    @Autowired
    private  TopicService topicService;

    @Test
    public void saveTopic(){
        Topic topic = new Topic();
        topic.setName("文学");
        topicService.saveTopic(topic);

    }

    /***
     * 测试更新专题
     */
    @Test
    public void updateTopic(){

        Topic topic = topicService.findTopic(47L);
        topic.setName("文学");
        topicService.saveTopic(topic);
    }

    /****
     * 测试收录文章
     */
    @Test
    public void includeArticle(){
        topicService.incioudArticle(47L,44L);


    }

    @Test
    public void findTopic(){
        Topic topic = topicService.findTopic(47L);
//        topic.getArticles();
//        System.out.println(JSON.toJSONString(topic,true));  //报错原因是调取toppic.getArticles()方法，session已经关闭了。也就是获取查询topic的session已经关闭了。
    }

    @Test
    public void unIncludeArticle(){
        topicService.unIncioudArticle(47L,44L);
    }

    @Test
    public void deleteTopic(){
        topicService.deleteTopic(47L);
    }



}