package com.example.helloworld.Services;

import com.example.helloworld.Interfaces.ICalendarManager;
import com.example.helloworld.Repositories.EventRepository;
import com.example.helloworld.Repositories.UserEventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.helloworld.models.Event;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@Component
// Add logging statements to each method
public class CalendarManager implements ICalendarManager {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    UserEventRepository userEventRepository;

    public Event addEvent(Event event) {
        // verify if participants are valid.
        Lock lock = new ReentrantLock();
        Event result = null;
        try {
            log.info("Adding event: " + event.toString());
            for (UUID participant : event.getParticipants()) {
                userEventRepository.addUserToEventPair(participant, event.getEventId());
            }
            userEventRepository.addUserToEventPair(event.getOrganizer(), event.getEventId());

            result = eventRepository.addOrUpdateEvent(event, event.getOrganizer());
        } finally {
            lock.unlock();
            log.info("Added event: " + event.toString());
            return result;
        }
    }

    public List<Event> getEvents(UUID userId) {
        List<UUID> eventIds = userEventRepository.getEventsGivenUser(userId);
        List<Event> events = new ArrayList<>();
        log.info("Getting events for user: " + userId.toString());
        for (UUID eventId: eventIds ) {
            events.add(eventRepository.getEvent(eventId));
        }
        log.info("Got events for user: " + userId.toString());
        return events;
    }

    public Event getEvent(UUID eventId) {
        return eventRepository.getEvent(eventId);
    }

    public Event deleteEvent(UUID event) {
        Lock lock = new ReentrantLock();
        Event result = null;
        try {
            log.info("Deleting event: " + event.toString());
            userEventRepository.deleteEvent(event);
            result =  eventRepository.deleteEvent(event);
        }
        finally {
            lock.unlock();
            log.info("Deleted event: " + event.toString());
            return result;
        }
    }

    public List<Event> getEventsForUser(UUID user) {
        List<UUID> eventIds = userEventRepository.getEventsGivenUser(user);
        List<Event> events = new ArrayList<>();
        log.info("Getting events for user: " + user.toString());
        for (UUID event: eventIds) {
            events.add(eventRepository.getEvent(event));
        }
        log.info("Got events for user: " + user.toString());
        return events;
    }
}
