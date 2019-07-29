package com.zhaopin.springbootjpa.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity//映射到数据库--》实体类
@Data
public class Wallet {
    @Id
    @GeneratedValue
    private long id;

    private BigDecimal balance;//余额

    @OneToOne(mappedBy = "wallet")//指定当前的Wallet是关系被维护者
    private Author author;

    public Wallet() {

    }

    public Wallet(BigDecimal balance) {
        this.balance = balance;
    }
}
