package com.zhaopin.springbootjpa.dataobject;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Topic {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @JSONField(serialize = true)
    @ManyToMany//多的这一端属性默认加载方式为LAZY

//    @JoinTable(
//            name ="t_topic_article",//指定表名
//            joinColumns = @JoinColumn(name = "topic_id",referencedColumnName = "id"),   //指定关系表维护方的关联字段
//            inverseJoinColumns = @JoinColumn(name = "article_id")
//    )
    private List<Article> articles = new ArrayList<>();//初始化   一个专题包含多个文章


    public Topic() {
    }
}
