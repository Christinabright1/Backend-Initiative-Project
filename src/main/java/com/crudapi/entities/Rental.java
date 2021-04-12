package com.crudapi.entities;

import java.util.Objects;

public class Rental {
    int rentalId;
    int userId;
    int movieId;

    public Rental(int rentalId, int userId, int movieId) {
        this.rentalId = rentalId;
        this.userId = userId;
        this.movieId = movieId;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rental)) return false;
        Rental rental = (Rental) o;
        return getRentalId() == rental.getRentalId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getMovieId());
    }
}
