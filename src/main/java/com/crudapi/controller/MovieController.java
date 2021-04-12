package com.crudapi.controller;

import com.crudapi.dataTransferObjects.MovieRequest;
import com.crudapi.entities.Movie;
import com.crudapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/allMovies")
    public ResponseEntity<Movie[]> getAllMovies() {
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/getMovie/{movieId}")
    public ResponseEntity<Movie> getMovie(@PathVariable int movieId) {
        return new ResponseEntity(movieService.getMovie(movieId), HttpStatus.OK);
    }

    @PostMapping("/addMovie/{movieId}")
    public ResponseEntity createMovie(@PathVariable int movieId, @RequestBody MovieRequest movie) {
        return new ResponseEntity(movieService.createMovie(movie, movieId), HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateMovie/{movieId}")
    public ResponseEntity<Movie[]> updateMovie(@PathVariable int movieId, @RequestBody MovieRequest movie) {
        return new ResponseEntity(movieService.updateMovie(movie, movieId), HttpStatus.OK);
    }

    @DeleteMapping("/deleteMovie/{movieId}")
    public ResponseEntity<Movie[]> deleteMovie(@PathVariable int movieId) {
        return new ResponseEntity(movieService.deleteMovie(movieId), HttpStatus.OK);
    }
}
