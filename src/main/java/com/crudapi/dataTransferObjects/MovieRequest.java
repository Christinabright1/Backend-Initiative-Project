package com.crudapi.dataTransferObjects;

import java.math.BigDecimal;

public class MovieRequest {
    String title;
    String description;
    String genre;
    BigDecimal rentalCost;
    int quantityInStock;

    public MovieRequest(String title, String description, String genre,
                        BigDecimal rentalCost, int quantityInStock) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.rentalCost = rentalCost;
        this.quantityInStock = quantityInStock;
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
}
