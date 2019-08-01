package com.zhaopin.springbootjpa.repository;

import com.zhaopin.springbootjpa.dataobject.Toppic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Toppic, Long> {
}
