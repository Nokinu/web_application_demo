package com.czhang.web_application_demo.mq;

import com.czhang.web_application_demo.bom.Comments;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import static com.czhang.web_application_demo.constants.MovieServiceConstants.MQ_COMMENTS_QUEUQ;


@Service
public class MQSender {

    private final RabbitTemplate rabbitTemplate;

    public MQSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendAddCommentsMessage(Comments comments) {
        rabbitTemplate.convertAndSend(MQ_COMMENTS_QUEUQ, comments);
    }
}
