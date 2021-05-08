package com.czhang.web_application_demo.controller;

import com.czhang.web_application_demo.aop.SystemLog;
import com.czhang.web_application_demo.bom.Post;
import com.czhang.web_application_demo.service.ThirdPartyAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ThirdPartyAPIController {

    private final ThirdPartyAPIService thirdPartyAPIService;

    public ThirdPartyAPIController(ThirdPartyAPIService thirdPartyAPIService) {
        this.thirdPartyAPIService = thirdPartyAPIService;
    }

    @SystemLog
    @GetMapping("/posts")
    @ResponseBody
    public ResponseEntity getAllPosts() {
        List<Post> posts = thirdPartyAPIService.getAllPosts();
        if(posts == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.of(Optional.of(posts));
    }
}
