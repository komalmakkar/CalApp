package com.example.helloworld.Interfaces;

import com.example.helloworld.models.User;
import com.example.helloworld.models.UserRequest;

import java.util.List;
import java.util.UUID;


public interface IUserService {
    User addOrUpdateUser(UserRequest request);

    User getUser(UUID id);

    List<User> getAllUsers();

    User deleteUser(UUID id);
}
