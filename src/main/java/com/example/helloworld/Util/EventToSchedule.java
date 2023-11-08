package com.example.helloworld.Util;

import com.example.helloworld.models.Event;
import com.example.helloworld.models.MiniEvent;
import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public final class EventToSchedule {
    public static
    ArrayList<MiniEvent> GetTime(List<Event> events) {
        ArrayList<MiniEvent> map = new ArrayList<>();

        for (Event event : events) {
            map.add(new MiniEvent(event.getEventId(), event.getStartHour(), event.getEndHour()));
        }

        return map;
    }
}
