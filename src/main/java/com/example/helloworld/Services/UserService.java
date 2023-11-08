package com.example.helloworld.Services;

import com.example.helloworld.Interfaces.IUserRepository;
import com.example.helloworld.Interfaces.IUserService;
import com.example.helloworld.models.ShiftTiming;
import com.example.helloworld.models.User;
import com.example.helloworld.models.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
@Component
@Slf4j
@Primary
public class UserService implements IUserService {
    @Autowired
    IUserRepository userRepository;

    @Override
    public User addOrUpdateUser(UserRequest request) {
        if(request.getShiftTiming() == null){
            request.setShiftTiming(new ShiftTiming());
        }
        User u = new User(UUID.randomUUID(), request.getUserName(), request.getShiftTiming() );
        userRepository.addOrUpdateUser(u);
        return u;
    }

    @Override
    public User getUser(UUID id) {
          return userRepository.getUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User deleteUser(UUID id) {
        return userRepository.deleteUser(id);
    }
}
