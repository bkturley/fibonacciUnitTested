package com.kturley;

public class StopWatch {

    long startTime;
    Long stopTime;

    public StopWatch() {
        start();
    }

    public void start() {
        startTime = System.nanoTime();
    }


    public Long stop() {
        long currentTime = System.nanoTime();
        return currentTime - startTime;
    }
    
    long getStartTime(){
        return startTime;
    }
}
