package com.example.helloworld.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Data
@AllArgsConstructor
public class Event {
     UUID EventId;
     UUID organizer;
     List<UUID> participants;
     int StartHour;
     int EndHour;
}
