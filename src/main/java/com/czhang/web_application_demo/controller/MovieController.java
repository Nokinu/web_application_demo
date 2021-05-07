package com.czhang.web_application_demo.controller;

import com.czhang.web_application_demo.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies_title/{title}")
    @ResponseBody
    public ResponseEntity<String> getMovieByTitle(@PathVariable(value = "title") String title) {
        if(movieService.getMovieByTitle(title) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.of(Optional.of(movieService.getMovieByTitle(title)));

    }
}
