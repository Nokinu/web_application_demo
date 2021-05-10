package com.czhang.web_application_demo.controller;

import com.czhang.web_application_demo.service.MovieService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class MovieControllerUnitTest {

    @Test
    public void getMovieByTitle() {
        MovieService movieService = Mockito.mock(MovieService.class);
        when(movieService.getMovieByTitle("Test")).thenReturn("Result");
        MovieController movieController = new MovieController(movieService);
        Assertions.assertEquals(movieController.getMovieByTitle("Test").getBody(), "Result");
    }
}
