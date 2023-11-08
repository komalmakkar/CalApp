package com.example.helloworld.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Calender {
    List<Event> eventsList;

    public Calender() {
        eventsList = new ArrayList<>();
    }
}
