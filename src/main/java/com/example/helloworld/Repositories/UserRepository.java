package com.example.helloworld.Repositories;

import com.example.helloworld.Interfaces.IUserRepository;
import com.example.helloworld.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Slf4j
@Repository
public class UserRepository implements IUserRepository {
    HashMap<UUID, User> usersStore;

    public UserRepository(){
        usersStore = new HashMap<UUID, User>();
    }
    @Override
    public User addOrUpdateUser(User user) {
        usersStore.put(user.getUserId(), user);
        return user;
    }

    @Override
    public User deleteUser(UUID id) {
        User u = usersStore.get(id);
        usersStore.remove(id);
        return u;
    }

    @Override
    public User getUser(UUID id) {
        return usersStore.get(id);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(usersStore.values());
    }
}
