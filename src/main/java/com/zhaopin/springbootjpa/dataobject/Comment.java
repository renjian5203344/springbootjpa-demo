package com.zhaopin.springbootjpa.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String content;

    @ManyToOne
    private Article article;


    public Comment() {
    }

    public Comment(String content) {
    this.content = content;
}
}
