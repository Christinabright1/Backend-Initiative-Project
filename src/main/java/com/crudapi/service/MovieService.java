package com.crudapi.service;

import com.crudapi.dataTransferObjects.MovieRequest;
import com.crudapi.entities.Movie;
import org.springframework.stereotype.Service;

@Service
public interface MovieService {
    Movie[] createMovie(MovieRequest movie, int movieId);

    Movie getMovie(int movieId);

    Movie[] getAllMovies();

    Movie updateMovie(MovieRequest movie, int movieId);

    Movie[] deleteMovie(int movieId);
}
