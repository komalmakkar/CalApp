package com.example.helloworld.Interfaces;

import com.example.helloworld.models.Event;

import java.util.List;
import java.util.UUID;

public interface IEventRepository {
    public Event addOrUpdateEvent(Event events, UUID organizer);

    public Event getEvent(UUID id);
    public Event deleteEvent(UUID id);
    List<Event> getAllEvents(UUID id);
}
