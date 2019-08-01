package com.zhaopin.springbootjpa.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Toppic {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    @ManyToMany
    private List<Article>  articles = new ArrayList<>();//初始化


    public Toppic() {
    }
}
