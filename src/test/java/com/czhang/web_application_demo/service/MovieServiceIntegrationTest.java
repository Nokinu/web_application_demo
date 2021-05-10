package com.czhang.web_application_demo.service;

import com.czhang.web_application_demo.bom.Movie;
import com.czhang.web_application_demo.repository.MovieRespository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@DataMongoTest
@RunWith(SpringRunner.class)
public class MovieServiceIntegrationTest {

    @Autowired
    private MovieRespository movieRespository;

    @Test
    public void getMovieByTitle() {
       MovieService movieService = new MovieService(movieRespository);
       Assertions.assertNotNull(movieService.getMovieByTitle("Blacksmith Scene"));
    }
}
