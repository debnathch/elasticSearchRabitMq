package com.example.blog.domain.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by debnathchatterjee on 19/05/19.
 */

@Data
@Document(indexName = "blog", type = "comments",shards = 1, replicas = 0,
        refreshInterval = "-1")
public class SrchbleCommt  {

    @Id
    private String id;

    private int comments_id;

    private int  posts_id;

    private int  user_id;

    private String body_comment;

    private int like_count;

    private Timestamp created_at;

    private Timestamp updated_at;

    public SrchbleCommt(
                        int comments_id,
                        int posts_id,
                        int user_id,
                        String body_comment,
                        int like_count,
                        Timestamp created_at,
                        Timestamp updated_at) {

        this.comments_id = comments_id;
        this.posts_id = posts_id;
        this.user_id = user_id;
        this.body_comment = body_comment;
        this.like_count = like_count;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

}
