package com.example.helloworld.ConflictManager;

import com.example.helloworld.Interfaces.IConflictFinder;
import com.example.helloworld.Util.EventToSchedule;
import com.example.helloworld.models.Event;
import com.example.helloworld.models.MiniEvent;
import com.example.helloworld.models.TimeSlots;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ConflictManager implements IConflictFinder {

    @Override
    public  ArrayList<MiniEvent> findConflict(List<Event> eventList) {
        ArrayList<MiniEvent> events = EventToSchedule.GetTime(eventList);

        events.sort(
                Comparator.comparingInt(x -> x.getStartTime())
        );
        UUID currentUser =events.get(0).getEventId();
        int[] currentRange = new int[] {
                events.get(0).getStartTime(),
                events.get(0).getEndTime()
        };
        ArrayList<MiniEvent> overlaps = new ArrayList<>();

        for (int i = 1; i < events.size(); i++) {
            int[] pair = new int[] {
                    events.get(i).getStartTime(),
                    events.get(i).getEndTime()
            };


            // Check if there is an overlap
            if (currentRange[1] >= pair[0]) {
                if(i == 1) {
                    overlaps.add(events.get(0));
                }
                overlaps.add(events.get(i));
            }
            currentUser = events.get(i).getEventId();
            currentRange = new int[] {
                    events.get(i).getStartTime(),
                    Math.max(currentRange[1], events.get(i).getEndTime())
            };
        }

        return overlaps;
    }

    public ArrayList<TimeSlots> findFreeSlots(List<Event> eventList) {
        ArrayList<MiniEvent> events = EventToSchedule.GetTime(eventList);

        events.sort(
                Comparator.comparingInt(x -> x.getStartTime())
        );
        UUID currentUser =events.get(0).getEventId();
        int[] currentRange = new int[] {
                events.get(0).getStartTime(),
                events.get(0).getEndTime()
        };
        ArrayList<TimeSlots> freeTime = new ArrayList<TimeSlots>();
        if( currentRange[0] > 0) {
            freeTime.add(new TimeSlots(0, currentRange[0]));
        }
        for (int i = 1; i < events.size(); i++) {
            int[] pair = new int[] {
                    events.get(i).getStartTime(),
                    events.get(i).getEndTime()
            };


            // Check if there is an overlap
            if (currentRange[1] < pair[0]) {
                freeTime.add(new TimeSlots(currentRange[1], pair[0]));
            }
            currentUser = events.get(i).getEventId();
            currentRange = new int[] {
                    events.get(i).getStartTime(),
                    Math.max(currentRange[1], events.get(i).getEndTime())
            };
        }
        if(currentRange[1] < 23) {
            freeTime.add(new TimeSlots(currentRange[1], 23));
        }
        return freeTime;
    }
}
