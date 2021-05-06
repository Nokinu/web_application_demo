package com.czhang.web_application_demo.redis;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RedisBloomFilter {

    private BloomFilter bloomFilter;

    @PostConstruct
    public void initBloomFilter() {
        bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), 1000000);
    }

    public <T> void addDataByBloomFilter(String key) {
        bloomFilter.put(key);
    }

    public boolean findDataByBloomFilter(String key) {
        //If not exist in bloom filter, then must be null.
        if(!bloomFilter.mightContain(key)) {
            return false;
        }
        return true;
    }
}
