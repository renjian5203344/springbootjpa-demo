package com.zhaopin.springbootjpa.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity//表示它对数据库进行映射
@Data
public class Article {
    @Id
    @GeneratedValue
    private Long id;
    private String title;    //标题
    private String content;  //内容                                                    //fetch默认值LAZY,当Article对象，从数据库里面映射获取它的一些数据出来的时候--》默认情况下comments情况下不去查询出来，只有你调用get()才会从数据库拿值
    @OneToMany(mappedBy = "article",cascade = {CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.EAGER) //指定当前的Article实体类和 Comment建立一多多的关系，通过Comment下面一个article属性来指定。
    private List<Comment> comments = new ArrayList<>();

    @ManyToMany(mappedBy = "articles") //这样两个实体类之间建立了多对多的关系
    private List<Topic> topics = new ArrayList<>();//初始化

    public void  addComment(Comment comment){
        comment.setArticle(this);
        comments.add(comment);
    }


    public Article() {
    }
}
