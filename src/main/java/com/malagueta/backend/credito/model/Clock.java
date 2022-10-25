package com.malagueta.backend.credito.model;

public class Clock {
    private int hour=0;
    private int min=0;
    private int sec=0;
    private static Clock instance= new Clock();

    public static Clock getInstance(){return instance;}

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }


}
