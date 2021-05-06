package com.czhang.web_application_demo.service;

import com.czhang.web_application_demo.redis.RedisBloomFilter;
import com.czhang.web_application_demo.repository.MovieRespository;
import com.github.xiaolyuh.annotation.Cacheable;
import com.github.xiaolyuh.annotation.FirstCache;
import com.github.xiaolyuh.annotation.SecondaryCache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

@Service
public class MovieService {

    private final MovieRespository movieRespository;
    private final RedisBloomFilter redisBloomFilter;
    private final RedisLockRegistry redisLockRegistry;
    private final RedisTemplate<String, Object> redisTemplate;
    private final static List<String> cacheWhiteList = new ArrayList<>();


    public MovieService(MovieRespository movieRespository, RedisBloomFilter redisBloomFilter, RedisLockRegistry redisLockRegistry, RedisTemplate<String, Object> redisTemplate) {
        this.movieRespository = movieRespository;
        this.redisBloomFilter = redisBloomFilter;
        this.redisLockRegistry = redisLockRegistry;
        this.redisTemplate = redisTemplate;
    }


    // Use 2 layer-cache to avoid Cache Avalanche
    @Cacheable(value="Movies", key = "#title", depict = "Movies Info Cache",
    firstCache = @FirstCache(expireTime = 2, timeUnit = TimeUnit.SECONDS),
    secondaryCache = @SecondaryCache(expireTime = 30, preloadTime = 3, forceRefresh = true, timeUnit = TimeUnit.SECONDS))
    public String getMovieByTitle(String title) {
        // Avoid Cache Penetration
        if(!redisBloomFilter.findDataByBloomFilter("Movies" + title)
        || cacheWhiteList.contains(title)) {
            return null;
        }
        String movie = null;
        // Use lock to avoid Hotspot Invalid - cache data is expired or out of date.
        Lock lock = redisLockRegistry.obtain("movie_lock" + title);
        try {
           boolean isLocked = lock.tryLock(20, TimeUnit.SECONDS);
           if(isLocked) {
               // use redis to double check if exists as bloom filter has False positive cases
               movie = (String) redisTemplate.opsForValue().get("Movies" + title);
               if(movie == null) {
                   movie = movieRespository.findByTitle(title);
                   if(movie == null) {
                       cacheWhiteList.add(title);
                   } else {
                       redisBloomFilter.addDataByBloomFilter("Movies" + title);
                       redisTemplate.opsForValue().set("Movies" + title, movie);
                   }
               }
           }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return movie;
    }
}
