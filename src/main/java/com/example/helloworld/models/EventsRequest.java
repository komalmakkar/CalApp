package com.example.helloworld.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Data
@AllArgsConstructor
public class EventsRequest {
    List<UUID> participants;
    // between 0 - 24
    int StartHour;

    // between 0 - 24
    int EndHour;
}
