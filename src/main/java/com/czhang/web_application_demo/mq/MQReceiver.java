package com.czhang.web_application_demo.mq;

import com.czhang.web_application_demo.bom.Comments;
import com.czhang.web_application_demo.service.CommentsService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import static com.czhang.web_application_demo.constants.MovieServiceConstants.MQ_COMMENTS_QUEUQ;


@Service
@RabbitListener(queues = MQ_COMMENTS_QUEUQ)
public class MQReceiver {

    private final CommentsService commentsService;

    public MQReceiver(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @RabbitHandler
    public void receiveAddCommentsMessage(Comments comments) {
      commentsService.addComments(comments);
    }
}
