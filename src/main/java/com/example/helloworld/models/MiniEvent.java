package com.example.helloworld.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
@Setter
@Getter
@AllArgsConstructor
public class MiniEvent {
    UUID eventId;

    // use timeslot object. applicable elsewhere.
    int startTime;
    int endTime;
}
