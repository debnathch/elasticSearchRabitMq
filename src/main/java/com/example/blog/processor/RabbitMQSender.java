package com.example.blog.processor;

import com.example.blog.domain.pojo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.awt.im.InputContext;

/**
 * Created by debnathchatterjee on 19/05/19.
 */
@Service
@Slf4j
public class RabbitMQSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("comment.rabbitmq.exchange")
    private String exchange;

    @Value("comment.rabbitmq.routingkey")
    private String routingkey;

    @Value("comment.rabbitmq.queue")
    String queueName;

    @Autowired
    private ObjectMapper objectMapper;

    public void send(InputComment comment) {
        try{

            String orderJson = objectMapper.writeValueAsString(comment);
            Message message = MessageBuilder
                    .withBody(orderJson.getBytes())
                    .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                    .build();

            rabbitTemplate.convertAndSend(queueName, comment);
            log.info("Send msg = " + comment);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}
