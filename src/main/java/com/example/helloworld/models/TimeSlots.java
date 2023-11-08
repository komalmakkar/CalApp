package com.example.helloworld.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
public class TimeSlots {
    int startTime;
    int endTime;
}
