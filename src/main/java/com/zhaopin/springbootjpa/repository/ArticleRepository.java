package com.zhaopin.springbootjpa.repository;


import com.zhaopin.springbootjpa.dataobject.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}
