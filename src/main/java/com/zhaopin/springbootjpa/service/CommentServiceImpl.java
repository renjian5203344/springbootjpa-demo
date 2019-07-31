package com.zhaopin.springbootjpa.service;

import com.zhaopin.springbootjpa.dataobject.Comment;
import com.zhaopin.springbootjpa.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    @Override
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Transactional
    @Override
    public void deleteComment(Long id) {

       Comment comment = commentRepository.findById(id).get();//查询出一个comment对象
        comment.clearComment();

//        List<Comment>  comments = comment.getArticle().getComments();
//        for (Comment comment1 : comments){
//            if(id == comment1.getId()){
//                comments.remove(comment1);
//                break;
//            }
//        }
        // commentRepository.deleteById(id);
         commentRepository.deleteBy(id);

    }
}
