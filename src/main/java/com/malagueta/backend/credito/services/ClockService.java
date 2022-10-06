package com.malagueta.backend.credito.services;


import com.malagueta.backend.credito.model.Clock;

public class ClockService {
    private Clock clock= Clock.getInstance();

    public int getHoras(){

        return clock.getHour();
    }

    public int geMin() {
        return clock.getMin();
    }
}
