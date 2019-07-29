package com.zhaopin.springbootjpa.repository;


import com.zhaopin.springbootjpa.dataobject.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
