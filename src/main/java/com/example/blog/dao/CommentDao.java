package com.example.blog.dao;

import com.example.blog.dao.repository.CommentRepository;
import com.example.blog.domain.dao.Comment;
import com.example.blog.domain.pojo.InputComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by debnathchatterjee on 19/05/19.
 */
@Component
public class CommentDao {

    @Autowired
    CommentRepository commentRepository;

    public Comment createComment(InputComment inputComment){

        Comment comment = new Comment();
        comment.setBody_comment(inputComment.getBody_comment());
        comment.setUser_id(inputComment.getUser_id());
        comment.setCreated_at(inputComment.getCreated_at());
        comment.setLike_count(inputComment.getLike_count());
        comment.setUpdated_at(inputComment.getUpdated_at());
        comment.setPosts_id(inputComment.getPosts_id());

        return commentRepository.save(comment);
    }


}
