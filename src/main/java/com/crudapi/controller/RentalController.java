package com.crudapi.controller;

import com.crudapi.dataTransferObjects.RentalRequest;
import com.crudapi.entities.Rental;
import com.crudapi.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {

    @Autowired
    RentalService rentalService;

    @GetMapping("/allRentals")
    public ResponseEntity<Rental[]> getAllRentals() {
        return new ResponseEntity<>(rentalService.getAllRentals(), HttpStatus.OK);
    }

    @GetMapping("/getRental/{rentalId}")
    public ResponseEntity<Rental> getRental(@PathVariable int rentalId) {
        return new ResponseEntity(rentalService.getRental(rentalId), HttpStatus.OK);
    }

    @PostMapping("/addRental/{rentalId}")
    public ResponseEntity createRental(@PathVariable int rentalId, @RequestBody RentalRequest rental) {
        return new ResponseEntity(rentalService.createRental(rental, rentalId), HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateRental/{rentalId}")
    public ResponseEntity<Rental[]> updateRental(@PathVariable int rentalId, @RequestBody RentalRequest rental) {
        return new ResponseEntity(rentalService.updateRental(rental, rentalId), HttpStatus.OK);
    }

    @DeleteMapping("/deleteRental/{rentalId}")
    public ResponseEntity<Rental[]> deleteRental(@PathVariable int rentalId) {
        return new ResponseEntity(rentalService.deleteRental(rentalId), HttpStatus.OK);
    }
}
