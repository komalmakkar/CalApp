package com.example.helloworld.Repositories;

import com.example.helloworld.Interfaces.IUserEventRepository;
import com.example.helloworld.models.UserEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Component
public class UserEventRepository implements IUserEventRepository {

    List<UserEvent> userToEventStore ;

    public UserEventRepository() {
        userToEventStore = new ArrayList<>() ;
    }

    public List<UUID> getEventsGivenUser(UUID userId) {
        return userToEventStore
                .stream()
                .filter(x -> x.getUserId().equals(userId))
                .map(x -> x.getEventId())
                .collect(Collectors.toList());

    }

    public List<UUID> getUsersGivenEvent(UUID eventId) {
        return userToEventStore
                .stream()
                .filter(x-> x.getEventId().equals(eventId))
                .map(x -> x.getUserId())
                .collect(Collectors.toList());
    }

    public void deleteEvent(UUID eventid){
        userToEventStore
                .removeIf(x -> x.getEventId().equals(eventid));
    }

    public void deleteUser(UUID userId) {
        userToEventStore
                .removeIf(x -> x.getUserId().equals(userId));

    }

    public void addUserToEventPair(UUID userId, UUID eventId) {
        userToEventStore.add(new UserEvent(userId, eventId));
    }

}
