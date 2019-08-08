package com.zhaopin.springbootjpa.repository;

import com.zhaopin.springbootjpa.dataobject.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
