package com.czhang.web_application_demo.controller;

import com.czhang.web_application_demo.aop.SystemLog;
import com.czhang.web_application_demo.bom.Comments;
import com.czhang.web_application_demo.mq.MQSender;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentsController {

    private final MQSender mqSender;

    public CommentsController(MQSender mqSender) {
        this.mqSender = mqSender;
    }

    @SystemLog
    @PostMapping("/comments")
    @ResponseBody
    public ResponseEntity<String> addComments(@RequestBody Comments comments) {
        mqSender.sendAddCommentsMessage(comments);
        return ResponseEntity.accepted().build();
    }
}
