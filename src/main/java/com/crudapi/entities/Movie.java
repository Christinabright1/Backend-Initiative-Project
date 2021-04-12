package com.crudapi.entities;

import java.math.BigDecimal;
import java.util.Objects;

public class Movie {
    int movieId;
    String title;
    String description;
    String genre;
    BigDecimal rentalCost;
    int quantityInStock;

    public Movie(int movieId, String title, String description, String genre,
                 BigDecimal rentalCost, int quantityInStock) {
        this.movieId = movieId;
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.rentalCost = rentalCost;
        this.quantityInStock = quantityInStock;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public BigDecimal getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(BigDecimal rentalCost) {
        this.rentalCost = rentalCost;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return getMovieId() == movie.getMovieId() && getTitle().equals(movie.getTitle())
                && getDescription().equals(movie.getDescription()) && getGenre().equals(movie.getGenre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMovieId(), getTitle(), getDescription(), getGenre());
    }
}