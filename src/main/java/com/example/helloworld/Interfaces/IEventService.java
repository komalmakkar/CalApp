package com.example.helloworld.Interfaces;

import com.example.helloworld.models.Event;
import com.example.helloworld.models.EventsRequest;
import com.example.helloworld.models.MiniEvent;
import com.example.helloworld.models.TimeSlots;
import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface IEventService {
    public Event addEvent(EventsRequest request, UUID organizer);

    public List<Event> getEvents(UUID userId);

    Event deleteEvent(UUID UserId, UUID eventId);

    ArrayList<MiniEvent> getConflictEvents(UUID UserId);

    List<TimeSlots> getFreeTimeSlots(List<UUID> users);
}


