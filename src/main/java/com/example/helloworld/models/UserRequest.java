package com.example.helloworld.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Validated
@Getter
@Setter
public class UserRequest {

    public String UserName;

    public ShiftTiming shiftTiming;

}
