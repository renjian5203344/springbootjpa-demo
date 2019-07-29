package com.zhaopin.springbootjpa.repository;


import com.zhaopin.springbootjpa.dataobject.Author;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Long> {

    List<Author>  findByPhoneAndNickName(String phone, String nickName);

    List<Author>  findByNickNameLike(String nickName);

    List<Author>  findDistinctByNickNameIgnoreCaseOrPhoneOrderBySingnDateDesc(String nickName, String phone);
//    @Query("select a from Author a where a.phone =?1")//Author 实体对象、?代表占位符、1代表第一个数字
//    @Query("select a from Author a where a.phone like ?1")//like第1种方式：？一个站位，这个时候【参数里面传递%这个占位】

//    @Query("select a from Author a where a.phone like %?1%")//【报红是验证的问题，语法没问题】
//    List<Author>  findByPhone(String phone);
//     另外一种传参方式
     @Query("select a from Author a where a.phone like %:phone%")//:phone相当于一个占位符
    List<Author>  findByPhone(@Param("phone") String phone);

     @Query("select a.nickName,length(a.nickName) from Author a where  a.nickName like %?1% ")
     List<Object[]> findArry(String nickName);

     @Query("select a from Author a where a.nickName like  %?1%")
     List<Author>  findByNickName(String nickName, Sort sort);

     @Query(value = "select * from author where nick_name like %?1%",nativeQuery = true)
     List<Author> findsql(String nickName);

     @Transactional
     @Modifying//可识别update语句执行
     @Query("update Author a set a.nickName = ?1 where a.phone = ?2")
     int setNickName(String nickName, String phone);


}

