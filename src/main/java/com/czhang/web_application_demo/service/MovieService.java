package com.czhang.web_application_demo.service;

import com.czhang.web_application_demo.aop.BloomFilterLimit;
import com.czhang.web_application_demo.aop.RateLimit;
import com.czhang.web_application_demo.aop.RedisLock;
import com.czhang.web_application_demo.aop.SystemLog;
import com.czhang.web_application_demo.repository.MovieRespository;
import com.github.xiaolyuh.annotation.Cacheable;
import com.github.xiaolyuh.annotation.FirstCache;
import com.github.xiaolyuh.annotation.SecondaryCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class MovieService {

    private final MovieRespository movieRespository;

    public MovieService(MovieRespository movieRespository) {
        this.movieRespository = movieRespository;
    }


    @SystemLog(description = "Return movie information by title")
    @RateLimit
    // Use Bloom filter to avoid Cache Penetration
    @BloomFilterLimit
    // Use 2 layer-cache to avoid Cache Avalanche
    @Cacheable(value="Movies", key = "#title", depict = "Movies Info Cache",
    firstCache = @FirstCache(expireTime = 5),
    secondaryCache = @SecondaryCache(expireTime = 15, preloadTime = 8, forceRefresh = true, timeUnit = TimeUnit.MINUTES))
    // Use lock to avoid Hotspot Invalid
    @RedisLock(lockKey = "T(com.czhang.web_application_demo.constants.MovieServiceConstants).MOVIE_LOCK_KEY")
    public String getMovieByTitle(String title) {
        return movieRespository.findByTitle(title);
    }
}
