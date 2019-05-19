package com.example.blog.domain.elasticDao;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by debnathchatterjee on 19/05/19.
 */
@Data
@Document(indexName = "blog", type = "comment", shards = 1, replicas = 0,
        refreshInterval = "-1")
public class SrchbleCommt implements Serializable  {

    @Id
    private String id;

    private int comments_id;

    private int  posts_id;

    private int  user_id;

    private String body_comment;

    private int like_count;

    private Timestamp created_at;

    private Timestamp updated_at;

    public SrchbleCommt(String id,
                        int comments_id,
                        int posts_id,
                        int user_id,
                        String body_comment,
                        int like_count,
                        Timestamp created_at,
                        Timestamp updated_at) {

        this.id = id;
        this.comments_id = comments_id;
        this.posts_id = posts_id;
        this.user_id = user_id;
        this.body_comment = body_comment;
        this.like_count = like_count;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

}
