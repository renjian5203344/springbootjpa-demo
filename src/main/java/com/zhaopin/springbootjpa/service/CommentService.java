package com.zhaopin.springbootjpa.service;

import com.zhaopin.springbootjpa.dataobject.Comment;

public interface CommentService {

    Comment saveComment(Comment comment);

    void deleteComment(Long id);


}
