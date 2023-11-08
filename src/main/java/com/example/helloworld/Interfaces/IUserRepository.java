package com.example.helloworld.Interfaces;

import com.example.helloworld.models.User;

import java.util.List;
import java.util.UUID;

public interface IUserRepository {
    public User addOrUpdateUser(User user);

    public User deleteUser(UUID id);

    public User getUser(UUID id);

    List<User> getAllUsers();
}
