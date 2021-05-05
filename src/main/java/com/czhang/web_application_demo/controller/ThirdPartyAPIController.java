package com.czhang.web_application_demo.controller;

import com.czhang.web_application_demo.bom.Post;
import com.czhang.web_application_demo.service.ThirdPartyAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class ThirdPartyAPIController {

    private final ThirdPartyAPIService thirdPartyAPIService;

    public ThirdPartyAPIController(ThirdPartyAPIService thirdPartyAPIService) {
        this.thirdPartyAPIService = thirdPartyAPIService;
    }

    @GetMapping("/posts")
    @ResponseBody
    public ResponseEntity getAllPosts() {
        List<Post> posts = thirdPartyAPIService.getAllPosts();
        return ResponseEntity.of(Optional.of(posts));
    }
}
