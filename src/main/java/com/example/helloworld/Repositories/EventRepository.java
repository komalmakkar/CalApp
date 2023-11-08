package com.example.helloworld.Repositories;

import com.example.helloworld.Interfaces.IEventRepository;
import com.example.helloworld.models.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
@Slf4j
public class EventRepository implements IEventRepository {

    HashMap<UUID, List<Event>> participantEventStore;

    public EventRepository(){
        participantEventStore = new HashMap<>();
    }

    @Override
    public Event addOrUpdateEvent(Event event, UUID userId) {
        List<UUID> participantIds = (ArrayList<UUID>) event.getParticipants();
        AddToEventStore(event, userId);
        for ( UUID participant : participantIds) {
            List<Event> events;
            AddToEventStore(event, participant);
        }
        return event;
    }

    @Override
    public Event getEvent(UUID eventId) {
        Collection<List<Event>> listOfEvents = participantEventStore.values();
        
        List<Event> listEvents = listOfEvents.stream().flatMap(List::stream).collect(Collectors.toList());
        
        return listEvents
                .stream()
                .filter(x -> x.getEventId().equals(eventId))
                .findAny().get();

    }

    @Override
    public Event deleteEvent(UUID eventId) {
        Event deleting = null;
        for (List<Event> events : participantEventStore.values()) {
            Iterator<Event> iterator = events.iterator();
            while (iterator.hasNext()) {
                Event event = iterator.next();
                if (event.getEventId().equals(eventId)) {
                    deleting = event;
                    iterator.remove();
                }
            }
        }
        return deleting;
    }

    private void AddToEventStore(Event event, UUID participant) {
        List<Event> events;
        if(!participantEventStore.containsKey(participant)){
             events = new ArrayList<>();
        }
        else {
            events = participantEventStore.get(participant);
        }
        events.add(event);
        participantEventStore.put(participant, events);
    }

    @Override
    public List<Event> getAllEvents(UUID id) {
        return participantEventStore.get(id);
    }
}
