package com.zhaopin.springbootjpa.dataobject;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
public class Topic {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    @JSONField(serialize = false)
    @ManyToMany //多的这一端属性默认加载方式为LAZY
    private List<Article> articles = new ArrayList<>();//初始化   一个专题里面可以包含多个文章


    public Topic() {
    }
}
