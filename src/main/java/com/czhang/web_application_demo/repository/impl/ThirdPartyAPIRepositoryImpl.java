package com.czhang.web_application_demo.repository.impl;

import com.alibaba.fastjson.JSONObject;
import com.czhang.web_application_demo.aop.SystemLog;
import com.czhang.web_application_demo.bom.Comments;
import com.czhang.web_application_demo.bom.Post;
import com.czhang.web_application_demo.constants.MovieServiceConstants;
import com.czhang.web_application_demo.repository.ThirdPartyAPIRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class ThirdPartyAPIRepositoryImpl implements ThirdPartyAPIRepository {

    private final RestTemplate restTemplate;

    public ThirdPartyAPIRepositoryImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    @SystemLog
    public List<Post> getAllPosts() {
        return restTemplate.getForObject(MovieServiceConstants.API_BASE_URL+"/posts", List.class);
    }

    @Override
    @SystemLog
    public boolean postComment(Comments comment) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", comment.getName());
        jsonObject.put("email", comment.getEmail());
        jsonObject.put("body", comment.getText());
        HttpEntity<JSONObject> httpEntity = new HttpEntity<>(jsonObject, headers);
        JSONObject result = restTemplate.postForObject(MovieServiceConstants.API_BASE_URL+"/posts/1/comments", httpEntity, JSONObject.class);
        return result != null;
    }
}
