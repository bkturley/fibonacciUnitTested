package com.kturley;

public class StopWatch {

    long startTime;

    public StopWatch() {
        start();
    }

    public long start() {
        startTime = System.nanoTime();
        return startTime;
    }

    public Long getElapsedTimeNanoSeconds() {
        long currentTime = System.nanoTime();
        return currentTime - startTime;
    }
    
    long getStartTime(){
        return startTime;
    }
}
