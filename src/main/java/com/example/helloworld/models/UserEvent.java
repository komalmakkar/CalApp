package com.example.helloworld.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Setter
@Getter
public class UserEvent {
    UUID userId;
    UUID eventId;
}
