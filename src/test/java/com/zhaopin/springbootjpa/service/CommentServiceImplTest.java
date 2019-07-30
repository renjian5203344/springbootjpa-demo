package com.zhaopin.springbootjpa.service;

import com.zhaopin.springbootjpa.dataobject.Article;
import com.zhaopin.springbootjpa.dataobject.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Id;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceImplTest {

    @Autowired
    private CommentService commentService;
    @Autowired
    private ArticleService articleService;

    @Test
    public void saveCommentTest() {

        Article article = articleService.findArticle(37L);
        Comment comment = new Comment();
        comment.setContent("关于互联网的思维....");
        comment.setArticle(article);
        commentService.saveComment(comment);


    }

    @Test
    public void deleteComment() {
        commentService.deleteComment(43L);


    }

}