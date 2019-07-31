package com.zhaopin.springbootjpa.repository;


import com.zhaopin.springbootjpa.dataobject.Comment;
import org.hibernate.sql.Delete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    @Transactional
    @Modifying //在commentserviceImpl实现类里面这个事务会覆盖 CommentRepository事务
    @Query("delete from Comment c where c.id=?1" ) //delete from 实体类
    void  deleteBy(Long id);
}
