package com.crudapi.service.serviceImplementation;

import com.crudapi.dataTransferObjects.MovieRequest;
import com.crudapi.entities.Movie;
import com.crudapi.service.MovieService;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImplementation implements MovieService {

    private Movie[] movies = new Movie[0];

    /*
    Linear-search function to find the index of an element in an array
     */
    public static int findIndex(Movie[] array, int id) {
        // if array is Null
        if (array == null) {
            return -1;
        }

        // find length of array
        int len = array.length;
        int i = 0;

        // traverse in the array
        while (i < len) {

            // if the i-th id is the same as the inputted id
            // then return the index
            if (array[i].getMovieId() == id) {
                return i;
            } else {
                i = i + 1;
            }
        }
        return -1;
    }

    //Method to add a new movie into movies Array
    private Movie[] addMovie(Movie[] moviesArray, Movie movie) {
        //Create a new array of a bigger size (+ one element)
        Movie[] proxyArray = new Movie[movies.length + 1];

        // insert the elements from the old array into the new one
        for (int i = 0; i < moviesArray.length; i++)
            proxyArray[i] = moviesArray[i];

        // add the new element to the last index of the new array
        proxyArray[moviesArray.length] = movie;

        /*
        check if new element is a duplicate, if so, discard it
         */
        for (Movie singleMovie : movies) {
            if (singleMovie.equals(movie)) {
                return moviesArray;
            }
        }

        return proxyArray;
    }

    //Method to remove a movie from movies Array
    private Movie[] removeMovie(int movieId) {
        //Create a new array of a bigger size (- one element)
        Movie[] proxyArray = new Movie[movies.length - 1];
        int userIndex = findIndex(movies, movieId);

        // copy all the elements in the original to proxy array except the one at index
        for (int i = 0, k = 0; i < movies.length; i++) {

            // check if index is crossed, continue without copying
            if (i == userIndex) {
                continue;
            }

            // else copy the element
            proxyArray[k++] = movies[i];
        }

        return proxyArray;
    }

    @Override
    public Movie[] createMovie(MovieRequest movie, int movieId) {
        Movie newMovie = new Movie(movieId, movie.getTitle(), movie.getDescription(),
                movie.getGenre(), movie.getRentalCost(), movie.getQuantityInStock());
        movies = addMovie(movies, newMovie);
        return movies;
    }

    @Override
    public Movie getMovie(int movieId) {
        Movie movieToGet = null;
        for(Movie singleMovie : movies){
            if(singleMovie.getMovieId() == movieId){
                movieToGet = new Movie(movieId, singleMovie.getTitle(), singleMovie.getDescription(),
                        singleMovie.getGenre(), singleMovie.getRentalCost(), singleMovie.getQuantityInStock());
                break;
            }
        }
        return movieToGet;
    }

    @Override
    public Movie[] getAllMovies() {
        return movies;
    }

    @Override
    public Movie updateMovie(MovieRequest movie, int movieId) {
        Movie movieToUpdate = null;
        for(Movie singleMovie : movies){
            if(singleMovie.getMovieId() == movieId){
                singleMovie.setTitle(movie.getTitle());
                singleMovie.setDescription(movie.getDescription());
                singleMovie.setGenre(movie.getGenre());
                singleMovie.setRentalCost(movie.getRentalCost());
                singleMovie.setQuantityInStock(movie.getQuantityInStock());
                movieToUpdate = singleMovie;
                break;
            }
        }
        return movieToUpdate;
    }

    @Override
    public Movie[] deleteMovie(int movieId) {
        movies = removeMovie(movieId);
        return movies;
    }
}
