package com.example.blog.controller.post;

import com.example.blog.dao.CommentDao;
import com.example.blog.dao.SearchCmmtsWithWordService;
import com.example.blog.domain.elasticDao.SrchbleCommt;
import com.example.blog.processor.RabbitMQSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.blog.domain.pojo.*;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by debnathchatterjee on 19/05/19.
 */
@Component
@RestController
@RequestMapping(value = "/blog")
@Slf4j
public class postComment {

    @Autowired
    RabbitMQSender rabbitMQSender;

    @Autowired
    private CommentDao commentDao;

   /* @Autowired
    private SearchCmmtsWithWordService searchCmmtsWithWordService;*/

    @RequestMapping(value = "/addToComment", method = RequestMethod.POST)
    public ResponseEntity<?> addToComment(@Valid @RequestBody InputComment inputComment) {

        inputComment.setCreated_at(new java.sql.Timestamp(System.currentTimeMillis()));
        inputComment.setUser_id(1);
        inputComment.setPosts_id(1);
        String result = "";
        log.info("incomming comment come as  : "+ inputComment.getBody_comment());
        if(commentDao.createComment(inputComment)!=null){
            if (postToQueue(inputComment)) {
                result = "post successfully send";
            }
        } else {
            result = "Exception occur. please repost again";
        }


        return ResponseEntity.ok(result);
    }

   /* @RequestMapping(value = "/searchWordsInComments", method = RequestMethod.POST)
    public ResponseEntity<?> searchWordInComment(@Valid @RequestBody String searchedWord) {

        List<SrchbleCommt> commtsList=  searchCmmtsWithWordService.findOneWord(searchedWord);
        Map<String, String > responseCommentMap =  new HashMap<>();
        for(SrchbleCommt commnt : commtsList){
            responseCommentMap.put(String.valueOf(commnt.getComments_id()),commnt.getBody_comment());
        }
        return ResponseEntity.ok(responseCommentMap);

    }*/


    public boolean postToQueue(InputComment inputComment){
        try{
            rabbitMQSender.send(inputComment);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

}
