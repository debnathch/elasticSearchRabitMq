package com.example.blog.domain.dao;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by debnathchatterjee on 19/05/19.
 */
@Entity
@Table(name="comments" , schema = "heroku_b0de01547793a0c")
@Data
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="comments_id")
    private int comments_id;

    @Column(name="posts_id")
    private int  posts_id;

    @Column(name="user_id")
    private int  user_id;

    @Column(name="body_comment")
    private String body_comment;

    @Column(name="like_count")
    private int like_count;

    @Column(name="created_at")
    private Timestamp created_at;

    @Column(name="updated_at")
    private Timestamp updated_at;

}
