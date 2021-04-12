package com.crudapi.service.serviceImplementation;

import com.crudapi.dataTransferObjects.UserRequest;
import com.crudapi.entities.User;
import com.crudapi.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

    private User[] users = new User[0];

    /*
    Linear-search function to find the index of an element in an array
     */
    public static int findIndex(User[] array, int id) {
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
            if (array[i].getId() == id) {
                return i;
            } else {
                i = i + 1;
            }
        }
        return -1;
    }

    //Method to add a new user into users Array
    private User[] addUser(User[] usersArray, User user) {
        //Create a new array of a bigger size (+ one element)
        User[] proxyArray = new User[users.length + 1];

        // insert the elements from the old array into the new one
        for (int i = 0; i < usersArray.length; i++)
            proxyArray[i] = usersArray[i];

        // add the new element to the last index of the new array
        proxyArray[usersArray.length] = user;

        /*
        check if new element is a duplicate, if so, discard it
         */
        for (User singleUser : users) {
            if (singleUser.equals(user)) {
                return usersArray;
            }
        }

        return proxyArray;
    }

    //Method to remove a user from users Array
    private User[] removeUser(int userId) {
        //Create a new array of a bigger size (- one element)
        User[] proxyArray = new User[users.length - 1];
        int userIndex = findIndex(users, userId);

        // copy all the elements in the original to proxy array except the one at index
        for (int i = 0, k = 0; i < users.length; i++) {

            // check if index is crossed, continue without copying
            if (i == userIndex) {
                continue;
            }

            // else copy the element
            proxyArray[k++] = users[i];
        }

        return proxyArray;
    }

    public User[] signUp(UserRequest user, int userId) {

        User newUser = new User(userId, user.getUsername(),
                user.getEmail(), user.getPassword());
        users = addUser(users, newUser);
        return users;
    }

    public User getUser(int userId) {
        User userToGet = null;
        for (User singleUser : users) {
            if (singleUser.getId() == userId) {
                userToGet = new User(singleUser.getId(), singleUser.getUsername(),
                        singleUser.getEmail(), singleUser.getPassword());
                break;
            }
        }
        return userToGet;
    }

    public User[] getAllUsers() {
        return users;
    }

    public User updateUser(UserRequest user, int userId) {
        User userToUpdate = null;
        for (User singleUser : users) {
            if (singleUser.getId() == userId) {
                singleUser.setUsername(user.getUsername());
                singleUser.setEmail(user.getEmail());
                singleUser.setPassword(user.getPassword());
                userToUpdate = singleUser;
                break;
            }
        }
        return userToUpdate;
    }

    public User[] deleteUser(int userId) {
        users = removeUser(userId);
        return users;
    }
}
