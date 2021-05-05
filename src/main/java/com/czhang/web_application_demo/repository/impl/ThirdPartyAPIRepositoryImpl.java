package com.czhang.web_application_demo.repository.impl;

import com.czhang.web_application_demo.bom.Post;
import com.czhang.web_application_demo.repository.ThirdPartyAPIRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class ThirdPartyAPIRepositoryImpl implements ThirdPartyAPIRepository {

    private final static String BASE_URL = "http://jsonplaceholder.typicode.com";

    private final RestTemplate restTemplate;

    public ThirdPartyAPIRepositoryImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public List<Post> getAllPosts() {
        return restTemplate.getForObject(BASE_URL+"/posts", List.class);
    }
}
