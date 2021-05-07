package com.czhang.web_application_demo.service;

import com.czhang.web_application_demo.bom.Post;
import com.czhang.web_application_demo.repository.ThirdPartyAPIRepository;
import com.github.xiaolyuh.annotation.Cacheable;
import com.github.xiaolyuh.annotation.FirstCache;
import com.github.xiaolyuh.annotation.SecondaryCache;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
@Retry(name = "retryA")
@CircuitBreaker(name = "cbA", fallbackMethod = "handleAPIError")
public class ThirdPartyAPIService {

    private final static Logger logger = LoggerFactory.getLogger(ThirdPartyAPIService.class);
    private final ThirdPartyAPIRepository thirdPartyAPIRepository;

    public ThirdPartyAPIService(ThirdPartyAPIRepository thirdPartyAPIRepository) {
        this.thirdPartyAPIRepository = thirdPartyAPIRepository;
    }

    @Cacheable(value="POSTS_ALL", depict = "Posts Info Cache",
            firstCache = @FirstCache(expireTime = 5),
            secondaryCache = @SecondaryCache(expireTime = 15, preloadTime = 8, forceRefresh = true, timeUnit = TimeUnit.MINUTES))
    public List<Post> getAllPosts() {
        logger.info("Call API for all posts");
        return thirdPartyAPIRepository.getAllPosts();
    }

    public List<Post> handleAPIError(Throwable throwable) {
        logger.error("CircuitBreaker for ThirdPartyAPIService : {}" ,throwable.toString());
       return null;
    }
}
