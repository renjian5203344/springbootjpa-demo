package com.zhaopin.springbootjpa.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity//把这个类，标识为数据模型类。 这样的话，它会把里面的属性，根据model类，创建一张表
@Data
public class Author {
    @Id  //主键
    @GeneratedValue
    //实体类模型对应数据库里面表的
    private long id;
    private String nickName; //昵称
    @Basic(fetch =FetchType.EAGER)
    private String phone;//手机号

    @Temporal(TemporalType.DATE)
    private Date singnDate;
    @OneToOne(cascade ={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE},optional = false,fetch = FetchType.EAGER)//optional = false设置默认值不允许为空
    @JoinColumn(name ="author_wallet_id")//指定外键生成的名字
    private  Wallet wallet; //一个作者对应一个钱包

    public Author() {
    }

}
