package com.czhang.web_application_demo.service;

import com.czhang.web_application_demo.repository.MovieRespository;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final MovieRespository movieRespository;

    public MovieService(MovieRespository movieRespository) {
        this.movieRespository = movieRespository;
    }

    public String getMovieByTitle(String title) {
        return movieRespository.findByTitle(title);
    }
}
