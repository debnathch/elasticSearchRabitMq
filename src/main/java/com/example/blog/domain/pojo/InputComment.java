package com.example.blog.domain.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.sql.Timestamp;

/**
 * Created by debnathchatterjee on 19/05/19.
 */
@Data
public class InputComment {

     int comments_id;

     int  posts_id;

     int  user_id;

     String body_comment;

     int like_count;

     Timestamp created_at;

     Timestamp updated_at;

     public InputComment(@JsonProperty("comments_id") int comments_id,
                          @JsonProperty("posts_id") int posts_id,
                          @JsonProperty("user_id") int user_id,
                         @JsonProperty("body_comment") String body_comment,
                         @JsonProperty("like_count") int like_count,
                         @JsonProperty("created_at") Timestamp created_at,
                         @JsonProperty("updated_at") Timestamp updated_at) {

          this.comments_id = comments_id;
          this.posts_id = posts_id;
          this.user_id = user_id;
          this.body_comment = body_comment;
          this.like_count = like_count;
          this.created_at = created_at;
          this.updated_at = updated_at;
     }


}
