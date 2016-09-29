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
        verifyNoMoreInteractions(mockPrintStream);
    }
    
    @Test
    public void testRun_PrintsErrorWhenUpperLimitParameterIsNonsense() {
        String[] args = new String[1];
        args[0] = "gibberish";
        testSubject.run(args);
        verify(mockPrintStream).println("Invalid upper limit parameter: " + args[0]);
        verifyNoMoreInteractions(mockPrintStream);
    }

    @Test
    public void testRun_PrintsErrorWhenUpperLimitParameterIsNegative() {
        String[] args = new String[1];
        args[0] = "-1234";
        testSubject.run(args);
        verify(mockPrintStream).println("Invalid upper limit parameter: " + args[0]);
        verifyNoMoreInteractions(mockPrintStream);
    }

    @Test
    public void testRun_reportsErrorWhenMoreThanOneInputParameterIsGiven() {
        String[] args = new String[2];
        args[0] = "100";
        args[1] = "200";
        testSubject.run(args);
        verify(mockPrintStream).println("Invalid parameter list.");
        verifyNoMoreInteractions(mockPrintStream);
    }

    @Test
    public void testRun_reportsSumOfEvenFibsWhenGivenValidInput() {

        when(mockStopWatch.stop()).thenReturn((long) 456000000);
        ArrayList<Integer> testArrayList = new ArrayList<>();
        when(mockFibonacciSequence.upTo(9000)).thenReturn(testArrayList);
        when(mockSumOfAllMultiples.of(2)).thenReturn(mockSumOfAllMultiples);
        when(mockSumOfAllMultiples.in(testArrayList)).thenReturn(mockSumOfAllMultiples);
        when(mockSumOfAllMultiples.value()).thenReturn(123);

        String[] testInput = new String[1];
        testInput[0] = "9000";
        testSubject.run(testInput);

        verify(mockStopWatch).start();
        verify(mockPrintStream).println("Sum of all even Fibonacci up to 9000: 123\nCalculation Time: 456000000 NanoSeconds.");
        verifyNoMoreInteractions(mockPrintStream);

    }

    @Test
    public void testFibberPrintStreamIsSystemOut(){
        assertEquals(System.out, new Fibber().printStream);
    }
}
