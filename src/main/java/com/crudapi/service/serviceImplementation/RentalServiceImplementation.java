package com.crudapi.service.serviceImplementation;

import com.crudapi.dataTransferObjects.RentalRequest;
import com.crudapi.entities.Rental;
import com.crudapi.service.RentalService;
import org.springframework.stereotype.Service;

@Service
public class RentalServiceImplementation implements RentalService {
    private Rental[] rentals = new Rental[0];

    /*
    Linear-search function to find the index of an element in an array
     */
    public static int findIndex(Rental[] array, int id) {
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
            if (array[i].getRentalId() == id) {
                return i;
            } else {
                i = i + 1;
            }
        }
        return -1;
    }

    //Method to add a new rental into rentals Array
    private Rental[] addRental(Rental[] rentalsArray, Rental rental) {
        //Create a new array of a bigger size (+ one element)
        Rental[] proxyArray = new Rental[rentals.length + 1];

        // insert the elements from the old array into the new one
        for (int i = 0; i < rentalsArray.length; i++)
            proxyArray[i] = rentalsArray[i];

        // add the new element to the last index of the new array
        proxyArray[rentalsArray.length] = rental;

        /*
        check if new element is a duplicate, if so, discard it
         */
        for (Rental singleRental : rentals) {
            if (singleRental.equals(rental)) {
                return rentalsArray;
            }
        }

        return proxyArray;
    }

    //Method to remove a rental from rentals Array
    private Rental[] removeRental(int rentalId) {
        //Create a new array of a bigger size (- one element)
        Rental[] proxyArray = new Rental[rentals.length - 1];
        int userIndex = findIndex(rentals, rentalId);

        // copy all the elements in the original to proxy array except the one at index
        for (int i = 0, k = 0; i < rentals.length; i++) {

            // check if index is crossed, continue without copying
            if (i == userIndex) {
                continue;
            }

            // else copy the element
            proxyArray[k++] = rentals[i];
        }

        return proxyArray;
    }

    @Override
    public Rental[] createRental(RentalRequest rental, int rentalId) {
        Rental newRental = new Rental(rentalId, rental.getUserId(), rental.getMovieId());
        rentals = addRental(rentals, newRental);
        return rentals;
    }

    @Override
    public Rental getRental(int rentalId) {
        Rental rentalToGet = null;
        for(Rental singleRental : rentals){
            if(singleRental.getRentalId() == rentalId){
                rentalToGet = new Rental(rentalId, singleRental.getUserId(), singleRental.getMovieId());
                break;
            }
        }
        return rentalToGet;
    }

    @Override
    public Rental[] getAllRentals() {
        return rentals;
    }

    @Override
    public Rental updateRental(RentalRequest rental, int rentalId) {
        Rental rentalToUpdate = null;
        for(Rental singleRental : rentals){
            if(singleRental.getRentalId() == rentalId){
                singleRental.setUserId(rental.getUserId());
                singleRental.setMovieId(rental.getMovieId());
                rentalToUpdate = singleRental;
                break;
            }
        }
        return rentalToUpdate;
    }

    @Override
    public Rental[] deleteRental(int rentalId) {
        rentals = removeRental(rentalId);
        return rentals;
    }
}
