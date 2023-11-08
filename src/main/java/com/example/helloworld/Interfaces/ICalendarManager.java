package com.example.helloworld.Interfaces;

import com.example.helloworld.models.Event;

import java.util.List;
import java.util.UUID;

public interface ICalendarManager {
    public Event addEvent(Event event);

    public List<Event> getEvents(UUID userId);

    public Event getEvent(UUID eventId);

    public Event deleteEvent(UUID event);
}
