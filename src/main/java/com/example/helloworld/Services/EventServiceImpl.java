package com.example.helloworld.Services;

import com.example.helloworld.Interfaces.ICalendarManager;
import com.example.helloworld.Interfaces.IConflictFinder;
import com.example.helloworld.Interfaces.IEventService;
import com.example.helloworld.models.Event;
import com.example.helloworld.models.EventsRequest;
import com.example.helloworld.models.MiniEvent;
import com.example.helloworld.models.TimeSlots;
import lombok.extern.slf4j.Slf4j;
import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Component
@Primary
@Slf4j
public class EventServiceImpl implements IEventService {

    @Autowired
    ICalendarManager calendarManager;

    @Autowired
    IConflictFinder conflictFinder;

    @Override
    public Event addEvent(EventsRequest request, UUID organizer) {
        Event event = new Event(UUID.randomUUID(), organizer, request.getParticipants(), request.getStartHour(), request.getEndHour());
        return calendarManager.addEvent(event);
    }

    @Override
    public List<Event> getEvents(UUID userId) {
        return calendarManager.getEvents(userId);
    }

    @Override
    public Event deleteEvent(UUID UserId, UUID eventId) {
        UUID organizer = calendarManager.getEvent(eventId).getOrganizer();
        Event e = null;
        if (organizer.equals(UserId)) {
            e = calendarManager.deleteEvent(eventId);
        }
        else {
            log.info("No event Found");
        }
        return e;
    }

    @Override
    public ArrayList<MiniEvent> getConflictEvents(UUID UserId) {
        List<Event> events = calendarManager.getEvents(UserId);
        if (events.size() == 0) {
            return new ArrayList<>();
        }
        return conflictFinder.findConflict(events);
    }

    public List<TimeSlots> getFreeTimeSlots(List<UUID> users) {
        List<Event> eventList = new ArrayList<>();
        for (UUID userId : users) {
            eventList.addAll(calendarManager.getEvents(userId));
        }
       return conflictFinder.findFreeSlots(eventList);

    }
}
