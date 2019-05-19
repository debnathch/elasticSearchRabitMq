package com.example.blog.processor;

import com.example.blog.dao.SearchCmmtsWithWordService;
import com.example.blog.domain.dao.SrchbleCommt;
import com.example.blog.domain.pojo.InputComment;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.RabbitListener;


/**
 * Created by debnathchatterjee on 19/05/19.
 */
@Component
@Slf4j
public class RabbitMQConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SearchCmmtsWithWordService searchCmmtsWithWordService;

    @RabbitListener(queues = "comment.rabbitmq.queue")
    public void receiveMessage(InputComment publishComment) {
        log.info("Recieved Comment From RabbitMQ ****** : " + publishComment.getBody_comment());

        SrchbleCommt srchbleCommt = new SrchbleCommt(publishComment.getComments_id(),publishComment.getPosts_id()
        ,publishComment.getUser_id(),publishComment.getBody_comment(), publishComment.getLike_count(),
                publishComment.getCreated_at(),publishComment.getUpdated_at());

       /* srchbleCommt.setBody_comment(publishComment.getBody_comment());
        srchbleCommt.setComments_id(publishComment.getComments_id());
        srchbleCommt.setCreated_at(publishComment.getCreated_at());
        srchbleCommt.setLike_count(publishComment.getLike_count());
        srchbleCommt.setPosts_id(publishComment.getPosts_id());
        srchbleCommt.setUpdated_at(publishComment.getUpdated_at());
        srchbleCommt.setUser_id(publishComment.getUser_id());*/

        searchCmmtsWithWordService.save(srchbleCommt);
    }

}
