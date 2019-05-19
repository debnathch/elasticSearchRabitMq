package com.example.blog.dao.repository;

import com.example.blog.domain.dao.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 * Created by debnathchatterjee on 19/05/19.
 */
@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {
}
