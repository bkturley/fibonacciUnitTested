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

    private String[] testinput;


    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        System.setOut(mockPrintStream);
        testSubject = new Fibber();
        testSubject.fibonacciSequence = mockFibonacciSequence;
        testSubject.sumOfAllMultiples = mockSumOfAllMultiples;
        testSubject.stopWatch = mockStopWatch;
        testinput = new String[1];
    }

    @After
    public void tearDown(){
        System.setOut(System.out);
    }

    @Test
    public void testRun_PrintsErrorWhenNoUpperLimitParameterIsProvided() {
        testinput = new String[0];
        testSubject.run(testinput);
        verify(mockPrintStream).println("Missing upper limit parameter.");
    }
    
    @Test
    public void testRun_PrintsErrorWhenUpperLimitParameterIsNonsense() {
        testinput[0] = "gibberish";
        testSubject.run(testinput);
        verify(mockPrintStream).println("Invalid upper limit parameter: " + testinput[0]);
    }

    @Test
    public void testRun_PrintsErrorWhenUpperLimitParameterIsNegative() {
        testinput[0] = "-1234";
        testSubject.run(testinput);
        verify(mockPrintStream).println("Invalid upper limit parameter: " + testinput[0]);
    }

    @Test
    public void testRun_reportsErrorWhenMoreThanOneInputParameterIsGiven() {
        testinput = new String[2];
        testinput[0] = "100";
        testinput[1] = "200";
        testSubject.run(testinput);
        verify(mockPrintStream).println("Invalid parameter list.");
    }

    @Test
    public void testRun_reportsSumOfEvenFibsWhenGivenValidInput() {

        when(mockStopWatch.stop()).thenReturn((long) 456000000);
        ArrayList<Integer> testArrayList = new ArrayList<>();
        when(mockFibonacciSequence.upTo(9000)).thenReturn(mockFibonacciSequence);
        when(mockFibonacciSequence.value()).thenReturn(testArrayList);
        when(mockSumOfAllMultiples.of(2)).thenReturn(mockSumOfAllMultiples);
        when(mockSumOfAllMultiples.in(testArrayList)).thenReturn(mockSumOfAllMultiples);
        when(mockSumOfAllMultiples.value()).thenReturn(123);

        testinput[0] = "9000";
        testSubject.run(testinput);

        verify(mockStopWatch).start();
        verify(mockPrintStream).println("Sum of all even Fibonacci up to 9000: 123" + System.getProperty("line.separator") + "Calculation Time: 456000000 NanoSeconds.");
    }

    @Test
    public void testRun_reportsLargestFibFound() {

        when(mockStopWatch.stop()).thenReturn((long) 456000000);
        ArrayList<Integer> testArrayList = new ArrayList<>();
        when(mockFibonacciSequence.upTo(9000)).thenReturn(mockFibonacciSequence);
        when(mockFibonacciSequence.largest()).thenReturn(1111);
        when(mockSumOfAllMultiples.of(2)).thenReturn(mockSumOfAllMultiples);
        when(mockSumOfAllMultiples.in(testArrayList)).thenReturn(mockSumOfAllMultiples);
        when(mockSumOfAllMultiples.value()).thenReturn(123);

        testinput[0] = "9000";
        testSubject.run(testinput);

        verify(mockStopWatch).start();
        verify(mockPrintStream).println("Sum of all even Fibonacci up to 9000: 123" + System.getProperty("line.separator") + "Calculation Time: 456000000 NanoSeconds.");
        verify(mockPrintStream).println("Largest Fibonacci number found: 1111");
    }

    @Test
    public void testFibberPrintStreamIsSystemOut(){
        assertEquals(System.out, new Fibber().printStream);
    }
}
