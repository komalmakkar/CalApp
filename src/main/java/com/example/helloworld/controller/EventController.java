package com.example.helloworld.controller;

import com.example.helloworld.Interfaces.IEventService;
import com.example.helloworld.models.Event;
import com.example.helloworld.models.EventsRequest;
import com.example.helloworld.models.MiniEvent;
import com.example.helloworld.models.TimeSlots;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController

public class EventController {

    @Autowired
    IEventService eventService;
    @GetMapping("/user/{id}/Event")
    public ResponseEntity<List<Event>> event(@PathVariable  UUID id){
        return new ResponseEntity<List<Event>>(this.eventService.getEvents(id), HttpStatus.OK);
    }

    @GetMapping("/user/{id}/Event/Conflict")
    public ResponseEntity<ArrayList<MiniEvent>> eventConflict(@PathVariable  UUID id){
        //return null;
        return new ResponseEntity<ArrayList<MiniEvent>> (this.eventService.getConflictEvents(id), HttpStatus.OK);
    }

    @PutMapping("/user/{id}/Event")
    public ResponseEntity<Event> event(@RequestBody EventsRequest eventsRequest, @PathVariable  UUID id){
        return new ResponseEntity<Event>( this.eventService.addEvent(eventsRequest, id), HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}/Event/{eventId}")
    public ResponseEntity<Event> user( @PathVariable  UUID id, @PathVariable UUID eventId){
        return new ResponseEntity<Event>( this.eventService.deleteEvent(id, eventId), HttpStatus.OK);
    }

    @PostMapping("/user/{id}/Event/FreeSlot")
    public ResponseEntity<ArrayList<TimeSlots>> user(@PathVariable  UUID id, @RequestBody List<UUID> userList){
        return new ResponseEntity<ArrayList<TimeSlots>>((ArrayList<TimeSlots>) this.eventService.getFreeTimeSlots(userList), HttpStatus.OK);
    }
}
