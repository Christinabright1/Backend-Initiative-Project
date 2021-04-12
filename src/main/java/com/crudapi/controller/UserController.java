package com.crudapi.controller;

import com.crudapi.dataTransferObjects.UserRequest;
import com.crudapi.entities.User;
import com.crudapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/allUsers")
    public ResponseEntity<User[]> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/getUser/{userId}")
    public ResponseEntity<User> getUser(@PathVariable int userId) {
        return new ResponseEntity(userService.getUser(userId), HttpStatus.OK);
    }

    @PostMapping("/signUp/{userId}")
    public ResponseEntity signUp(@PathVariable int userId, @RequestBody UserRequest user) {
        return new ResponseEntity(userService.signUp(user, userId), HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<User[]> updateUser(@PathVariable int userId, @RequestBody UserRequest user) {
        return new ResponseEntity(userService.updateUser(user, userId), HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<User[]> deleteUser(@PathVariable int userId) {
        return new ResponseEntity(userService.deleteUser(userId), HttpStatus.OK);
    }
}