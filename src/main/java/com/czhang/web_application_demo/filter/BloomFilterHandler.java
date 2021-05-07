package com.czhang.web_application_demo.filter;

import com.czhang.web_application_demo.bom.Movie;
import com.czhang.web_application_demo.repository.MovieRespository;
import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.slf4j.*;
import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class BloomFilterHandler {

    private static final Logger logger = LoggerFactory.getLogger(BloomFilterHandler.class);
    private static BloomFilter bloomFilter;

    private final MovieRespository movieRespository;

    public BloomFilterHandler(MovieRespository movieRespository) {
        this.movieRespository = movieRespository;
    }

    @PostConstruct
    public void initBloomFilter() {
        logger.info("Init Bloom Filter during service startup");
       createBloom();
       logger.info("End init BloomFilter");
    }

    private void createBloom() {
        List<Movie> movieList = movieRespository.findAll();
        bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), movieList.size());
        movieList.forEach(movie->addDataByBloomFilter(movie.getTitle()));
    }

    @Scheduled(cron = "0 0 4 * * ?")
    public void dailyTaskToRefreshBloomFilter() {
        logger.info("Start Daily Bloom Filter update");
        createBloom();
        logger.info("End Daily Bloom Filter update");
    }

    public static <T> void addDataByBloomFilter(String key) {
        bloomFilter.put(key);
    }

    public static boolean findDataByBloomFilter(String key) {
        //If not exist in bloom filter, then must be null.
        if(!bloomFilter.mightContain(key)) {
            return false;
        }
        return true;
    }
}
