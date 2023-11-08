package com.example.helloworld.Interfaces;

import com.example.helloworld.models.Event;
import com.example.helloworld.models.MiniEvent;
import com.example.helloworld.models.TimeSlots;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface IConflictFinder {
    public ArrayList<MiniEvent>  findConflict(List<Event> eventList);

    public ArrayList<TimeSlots> findFreeSlots(List<Event> eventList);

    }
