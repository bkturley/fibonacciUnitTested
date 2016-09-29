
package com.kturley;

import org.junit.Test;
import static org.junit.Assert.*;

public class StopWatchTest {



    @Test
    public void testStart() {
        StopWatch stopWatch = new StopWatch();
        long expectedResult = stopWatch.startTime;
        long testResult = stopWatch.startTime;
        assertEquals(testResult, expectedResult);
    }

    @Test
    public void testReportElapsedTime_AccurateToOneHundredthSecond() {
        //testing time measurement is hard, sorta like testing a random number generator.
        long controlStartTime = System.nanoTime();
        StopWatch stopWatch = new StopWatch();
        for(int count = 0; count < 9999999; count++);        
        long testElapsedTime = stopWatch.stop();
        long controlElapsedTime = System.nanoTime() - controlStartTime;
        boolean accurateToWithinOneHundredthSecond = (controlElapsedTime - testElapsedTime) <= 10000000;
        assertTrue(accurateToWithinOneHundredthSecond);
    }

}
