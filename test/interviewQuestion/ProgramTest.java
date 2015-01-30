package interviewQuestion;

import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ProgramTest {

    public ProgramTest() {
    }

    @Test
    public void testRun_reportsErrorWhenNoUpperLimitParameterIsProvided() {
        String[] args = new String[0];
        Program testObject = new Program();

        StopWatch mockStopWatch = mock(StopWatch.class);
        FibonnociSequenceGenerator mockFibonnociSequenceGenerator = mock(FibonnociSequenceGenerator.class);
        SumOfAllMultiplesAdder mockEvenNumberAdder = mock(SumOfAllMultiplesAdder.class);
        ArrayList mockArrayList = mock(ArrayList.class);
        when(mockFibonnociSequenceGenerator.getFibonnociSequenceUpTo(9000)).thenReturn(mockArrayList);

        PrintStream mockPrintStream = mock(PrintStream.class);
        PrintStream defaultPrintStream = System.out;

        System.setOut(mockPrintStream);
        testObject.run(args, mockStopWatch, mockFibonnociSequenceGenerator, mockEvenNumberAdder, mockPrintStream);
        System.setOut(defaultPrintStream);

        verify(mockPrintStream).println("Missing upper limit parameter.");
    }
    
        @Test
    public void testRun_reportsErrorWhenUpperLimitParameterIsInvalid() {
        String[] args = new String[1];
        args[0] = "gibberish";
        Program testObject = new Program();

        StopWatch mockStopWatch = mock(StopWatch.class);
        FibonnociSequenceGenerator mockFibonnociSequenceGenerator = mock(FibonnociSequenceGenerator.class);
        SumOfAllMultiplesAdder mockEvenNumberAdder = mock(SumOfAllMultiplesAdder.class);
        ArrayList mockArrayList = mock(ArrayList.class);
        when(mockFibonnociSequenceGenerator.getFibonnociSequenceUpTo(9000)).thenReturn(mockArrayList);

        PrintStream mockPrintStream = mock(PrintStream.class);
        PrintStream defaultPrintStream = System.out;

        System.setOut(mockPrintStream);
        testObject.run(args, mockStopWatch, mockFibonnociSequenceGenerator, mockEvenNumberAdder, mockPrintStream);
        System.setOut(defaultPrintStream);

        verify(mockPrintStream).println("Invalid upper limit parameter: " + args[0]);
    }

    @Test
    public void testRun_reportsErrorWhenMoreThanOneInputParameterIsGiven() {
        String[] args = new String[2];
        args[0] = "100";
        args[1] = "100";
        Program testObject = new Program();

        StopWatch mockStopWatch = mock(StopWatch.class);
        FibonnociSequenceGenerator mockFibonnociSequenceGenerator = mock(FibonnociSequenceGenerator.class);
        SumOfAllMultiplesAdder mockEvenNumberAdder = mock(SumOfAllMultiplesAdder.class);
        ArrayList mockArrayList = mock(ArrayList.class);
        when(mockFibonnociSequenceGenerator.getFibonnociSequenceUpTo(9000)).thenReturn(mockArrayList);

        PrintStream mockPrintStream = mock(PrintStream.class);
        PrintStream defaultPrintStream = System.out;

        System.setOut(mockPrintStream);
        testObject.run(args, mockStopWatch, mockFibonnociSequenceGenerator, mockEvenNumberAdder, mockPrintStream);
        System.setOut(defaultPrintStream);

        verify(mockPrintStream).println("Invalid parameter list.");
    }

    @Test
    public void testRun_reportsSumOfEvenFibsWhenGivenValidInput() {
        String[] args = new String[1];
        args[0] = "9000";
        StopWatch mockStopWatch = mock(StopWatch.class);
        when(mockStopWatch.getElapsedTimeNanoSeconds()).thenReturn((long) 456000000);

        FibonnociSequenceGenerator mockFibonnociSequenceGenerator = mock(FibonnociSequenceGenerator.class);
        ArrayList<Integer> testArrayList = new ArrayList<Integer>();
        when(mockFibonnociSequenceGenerator.getFibonnociSequenceUpTo(9000)).thenReturn(testArrayList);

        SumOfAllMultiplesAdder mockSumOfAllMultiplesAdder = mock(SumOfAllMultiplesAdder.class);
        when(mockSumOfAllMultiplesAdder.getSumOfAllMultiplesOf(testArrayList, 2)).thenReturn(123);

        PrintStream mockPrintStream = null;

        PrintStream defaultPrintStream = System.out;
        mockPrintStream = mock(PrintStream.class);

        System.setOut(mockPrintStream);

        Program testObject = new Program();
        testObject.run(args, mockStopWatch, mockFibonnociSequenceGenerator, mockSumOfAllMultiplesAdder, mockPrintStream);

        System.setOut(defaultPrintStream);

        verify(mockStopWatch).getElapsedTimeNanoSeconds();
        verifyNoMoreInteractions(mockStopWatch);

        verify(mockFibonnociSequenceGenerator).getFibonnociSequenceUpTo(9000);
        verifyNoMoreInteractions(mockFibonnociSequenceGenerator);

        verify(mockSumOfAllMultiplesAdder).getSumOfAllMultiplesOf(testArrayList, 2);
        verifyNoMoreInteractions(mockSumOfAllMultiplesAdder);

        verify(mockPrintStream).println("Sum of all even Fibonacci up to 9000: 123");
        verify(mockPrintStream).println("Calculation Time: 456 MilliSeconds.");
        verifyNoMoreInteractions(mockPrintStream);

    }

//        try {
//            PrintStream = new PrintStream(new File("file.txt")); 
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(ProgramTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
}
