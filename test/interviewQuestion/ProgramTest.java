
package interviewQuestion;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ProgramTest {

    public ProgramTest() {
    }

    @Test
    public void testRun_reportsCorrectAnswer() {
        String[] args = new String[1];
//        args[0] = "9000";
        Program instance = new Program();
        int expectedResult = 4613732;

        StopWatch mockStopWatch = mock(StopWatch.class);
        FibonnociSequenceGenerator mockFibonnociSequenceGenerator = mock(FibonnociSequenceGenerator.class);
        SumOfAllMultiplesAdder mockEvenNumberAdder = mock(SumOfAllMultiplesAdder.class);
        
        ArrayList mockArrayList = mock(ArrayList.class);

        when(mockFibonnociSequenceGenerator.getFibonnociSequenceUpTo(9000)).thenReturn(mockArrayList);
        when(mockEvenNumberAdder.getSumOfAllMultiplesOf(mockArrayList, 2)).thenReturn(expectedResult);
        
        OutputStream mockOutputStream = mock(OutputStream.class);
        PrintStream mockPrintStream  = mock(PrintStream.class);
        PrintStream defaultPrintStream = System.out;
        System.setOut(mockPrintStream);
        
        instance.run(args, mockStopWatch, mockFibonnociSequenceGenerator, mockEvenNumberAdder, mockPrintStream);

        System.setOut(defaultPrintStream);
        
        verify(mockPrintStream).println("Invalid upper limit parameter: " + args[0]);
        
//        verify(mockFibonnociSequenceGenerator).getFibonnociSequenceUpTo(9000);
        verifyNoMoreInteractions(mockFibonnociSequenceGenerator);
        
//        verify(mockEvenNumberAdder).getSumOfAllMultiplesOf(mockArrayList, 2);
        verifyNoMoreInteractions(mockEvenNumberAdder);
    }

}
