
package interviewQuestion;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ProgramTest {

    public ProgramTest() {
    }

    @Test
    public void testRun_providesCorrectAnswer() {
        String[] args = null;
        Program instance = new Program();
        int expectedResult = 4613732;
        int fourMillion = 4000000;

        StopWatch mockStopWatch = mock(StopWatch.class);
        FibonnociSequenceGenerator mockFibonnociSequenceGenerator = mock(FibonnociSequenceGenerator.class);
        EvenNumberAdder mockEvenNumberAdder = mock(EvenNumberAdder.class);

        ArrayList mockArrayList = mock(ArrayList.class);

        when(mockFibonnociSequenceGenerator.getFibonnociSequenceUpTo(fourMillion)).thenReturn(mockArrayList);
        when(mockEvenNumberAdder.getSumOfEvenContent(mockArrayList)).thenReturn(expectedResult);
        
        int testResult = instance.run(args, mockStopWatch, mockFibonnociSequenceGenerator, mockEvenNumberAdder);

        assertEquals(expectedResult, testResult);
        
        verify(mockFibonnociSequenceGenerator).getFibonnociSequenceUpTo(fourMillion);
        verifyNoMoreInteractions(mockFibonnociSequenceGenerator);
        
        verify(mockEvenNumberAdder).getSumOfEvenContent(mockArrayList);
        verifyNoMoreInteractions(mockEvenNumberAdder);
    }

}
