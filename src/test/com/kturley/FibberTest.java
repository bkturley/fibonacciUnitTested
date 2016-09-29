package com.kturley;

import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class FibberTest {

    Fibber testSubject;

    @Mock
    private FibonacciSequence mockFibonacciSequence;
    @Mock
    private SumOfAllMultiples mockSumOfAllMultiples;
    @Mock
    private StopWatch mockStopWatch;
    @Mock
    private PrintStream mockPrintStream;


    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        System.setOut(mockPrintStream);
        testSubject = new Fibber();
        testSubject.fibonacciSequence = mockFibonacciSequence;
        testSubject.sumOfAllMultiples = mockSumOfAllMultiples;
        testSubject.stopWatch = mockStopWatch;
    }

    @After
    public void tearDown(){
        System.setOut(System.out);
    }

    @Test
    public void testRun_PrintsErrorWhenNoUpperLimitParameterIsProvided() {
        String[] args = new String[0];
        testSubject.run(args);
        verify(mockPrintStream).println("Missing upper limit parameter.");
    }
    
    @Test
    public void testRun_PrintsErrorWhenUpperLimitParameterIsInvalid() {
        String[] args = new String[1];
        args[0] = "gibberish";

        FibonacciSequence mockFibonnociSequenceGenerator = mock(FibonacciSequence.class);
        ArrayList mockArrayList = mock(ArrayList.class);
        when(mockFibonnociSequenceGenerator.upTo(9000)).thenReturn(mockArrayList);

        PrintStream mockPrintStream = mock(PrintStream.class);
        PrintStream defaultPrintStream = System.out;

        System.setOut(mockPrintStream);
        testSubject.run(args);
        System.setOut(defaultPrintStream);

        verify(mockPrintStream).println("Invalid upper limit parameter: " + args[0]);
    }

    @Test
    public void testRun_reportsErrorWhenMoreThanOneInputParameterIsGiven() {
        String[] args = new String[2];
        args[0] = "100";
        args[1] = "200";

        ArrayList mockArrayList = mock(ArrayList.class);
        when(mockFibonacciSequence.upTo(9000)).thenReturn(mockArrayList);

        PrintStream mockPrintStream = mock(PrintStream.class);
        PrintStream defaultPrintStream = System.out;

        System.setOut(mockPrintStream);
        testSubject.run(args);
        System.setOut(defaultPrintStream);

        verify(mockPrintStream).println("Invalid parameter list.");
    }

//    @Test
//    public void testRun_reportsSumOfEvenFibsWhenGivenValidInput() {
//        String[] testInput = new String[1];
//        testInput[0] = "9000";
//        when(mockStopWatch.getElapsedTimeNanoSeconds()).thenReturn((long) 456000000);
//
//        ArrayList<Integer> testArrayList = new ArrayList<>();
//        when(mockFibonacciSequence.upTo(9000)).thenReturn(testArrayList);
//
//        when(mockSumOfAllMultiples.of(testArrayList, 2)).thenReturn(123);
//
//        PrintStream defaultPrintStream = System.out;
//
//        System.setOut(mockPrintStream);
//
//        testSubject.run(testInput);
//
//        System.setOut(defaultPrintStream);
//
//        verify(mockStopWatch).getElapsedTimeNanoSeconds();
//        verifyNoMoreInteractions(mockStopWatch);
//
//        verify(mockFibonacciSequence).upTo(9000);
//        verifyNoMoreInteractions(mockFibonacciSequence);
//
//        verify(mockSumOfAllMultiples).of(testArrayList, 2);
//        verifyNoMoreInteractions(mockSumOfAllMultiples);
//
//        verify(mockPrintStream).println("Sum of all even Fibonacci up to 9000: 123");
//        verify(mockPrintStream).println("Calculation Time: 456 MilliSeconds.");
//        verifyNoMoreInteractions(mockPrintStream);
//
//    }

    @Test
    public void testFibberPrintStreamIsSystemOut(){
        assertEquals(System.out, new Fibber().printStream);
    }
}
