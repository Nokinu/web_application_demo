package com.czhang.web_application_demo.service;

import com.czhang.web_application_demo.repository.MovieRespository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class MovieServiceUnitTest {

    @Test
    public void getMovieByTitle() {
        MovieRespository movieRespository = Mockito.mock(MovieRespository.class);
        MovieService movieService = new MovieService(movieRespository);
        when(movieRespository.findByTitle("Test")).thenReturn("Service");
        Assertions.assertEquals(movieService.getMovieByTitle("Test"), "Service");

    }
}
