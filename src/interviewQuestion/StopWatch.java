package interviewQuestion;


public class StopWatch {
    private long startTime;
    
    public void start(){
        startTime = System.nanoTime();
    }
    
    public Long getElapsedTimeNanoSeconds(){
        long currentTime = System.nanoTime();
        return currentTime - startTime;
    }
}
