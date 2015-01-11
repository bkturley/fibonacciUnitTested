
package interviewQuestion;

import org.junit.Test;
import static org.junit.Assert.*;

public class StopWatchTest {

    public StopWatchTest() {
    }

    @Test
    public void testStart() {
        StopWatch stopWatch = new StopWatch();
        long expectedResult = stopWatch.getStartTime();
        long testResult = stopWatch.startTime;
        assertEquals(testResult, expectedResult);
    }

    @Test
    public void testReportElapsedTime_AccurateToOneHundrethSecond() {
        long startTime = System.nanoTime();
        StopWatch stopWatch = new StopWatch();
        for(int count = 0; count < 9999999; count++);        
        long testElapsedTime = stopWatch.getElapsedTimeNanoSeconds();        
        long controlElapsedTime = System.nanoTime() - startTime;        
        boolean accurateToWithinOneMilliecond = (controlElapsedTime - testElapsedTime) <= 10000000;
        assertTrue(accurateToWithinOneMilliecond);
    }

}
