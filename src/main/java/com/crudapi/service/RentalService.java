package com.crudapi.service;

import com.crudapi.dataTransferObjects.RentalRequest;
import com.crudapi.entities.Rental;
import org.springframework.stereotype.Service;

@Service
public interface RentalService {
    Rental[] createRental(RentalRequest rental, int rentalId);

    Rental getRental(int rentalId);

    Rental[] getAllRentals();

    Rental updateRental(RentalRequest rental, int rentalId);

    Rental[] deleteRental(int rentalId);
}
