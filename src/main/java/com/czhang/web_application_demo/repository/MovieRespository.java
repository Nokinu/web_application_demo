package com.czhang.web_application_demo.repository;


import com.czhang.web_application_demo.bom.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRespository extends MongoRepository<Movie, String>, CustomMovieRespository {

    String findByTitle(String title);
}
