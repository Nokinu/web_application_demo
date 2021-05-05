package com.czhang.web_application_demo.service;

import com.czhang.web_application_demo.bom.Post;
import com.czhang.web_application_demo.repository.ThirdPartyAPIRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThirdPartyAPIService {

    private final ThirdPartyAPIRepository thirdPartyAPIRepository;

    public ThirdPartyAPIService(ThirdPartyAPIRepository thirdPartyAPIRepository) {
        this.thirdPartyAPIRepository = thirdPartyAPIRepository;
    }

    public List<Post> getAllPosts() {
        return thirdPartyAPIRepository.getAllPosts();
    }
}
