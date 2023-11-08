package com.example.helloworld.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class ShiftTiming {

    public ShiftTiming(){
        this.LoginHour = 9;
        this.LogoutHour = 17;
    }

    public void ShiftTiming(int login, int logout){
        this.LogoutHour = logout;
        this.LoginHour = login;
    }
    public int LoginHour = 9;
    public int LogoutHour = 17;
}
