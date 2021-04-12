package com.crudapi.service;

import com.crudapi.dataTransferObjects.UserRequest;
import com.crudapi.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User[] signUp(UserRequest user, int userId);

    User getUser(int userId);

    User[] getAllUsers();

    User updateUser(UserRequest user, int userId);

    User[] deleteUser(int userId);
}