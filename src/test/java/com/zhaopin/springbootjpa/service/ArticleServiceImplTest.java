package com.zhaopin.springbootjpa.service;

import com.alibaba.fastjson.JSON;
import com.zhaopin.springbootjpa.dataobject.Article;
import com.zhaopin.springbootjpa.dataobject.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceImplTest {

    @Autowired//注入
    private ArticleService articleService;

    @Test
    public void savearticle(){
        Article article = new Article();
        article.setTitle("关于创建");
        article.setContent("关于创基业的一些想法.....");

        Comment comment1 = new Comment("评论内容1");
        Comment comment2 = new Comment("评论内容2");

        article.addComment(comment1);
        article.addComment(comment2);

        Article article2 = articleService.saveArticle(article);

    }


    @Test
    public void updateArticle(){
        Article article = articleService.findArticle(40L);
        article.setContent("游记的一些所见所闻");
        articleService.updateArticle(article);

    }
    @Test
    public void findArticle(){
        Article article = articleService.findArticle(37L);
        System.out.println(JSON.toJSONString(article,true));//使用JSON.toJSONString格式化打印出来的时候，需要拿到里面的list,拿到list我们又没有调用get方法


    }

    @Test
    public void deleteArticle(){
        articleService.deleteArticle(8L);

    }


}