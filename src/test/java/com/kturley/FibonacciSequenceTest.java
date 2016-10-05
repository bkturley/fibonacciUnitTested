package com.kturley;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FibonacciSequenceTest {

    private FibonacciSequence testSubject;

    @Before
    public void setup(){
        testSubject = new FibonacciSequence();
    }

    @Test
    public void testUpToReturnsSelfWithStateSet() {
        Integer upToHere = 999999;
        assertEquals(testSubject, testSubject.upTo(upToHere));
        assertEquals(upToHere, testSubject.upToHere);
    }

    @Test
    public void testValueReturnsFibsUpToValue(){
        Integer upToHere = 999999;
        assertEquals(knownGoodFibSequenceAlgorithm(upToHere), testSubject.upTo(upToHere).value());
    }

    @Test
    public void testLargestReturnsLargestFibInValue(){
        Integer upToHere = 999999;
        assertEquals(knownGoodLargestAlgorithm(knownGoodFibSequenceAlgorithm(upToHere)), testSubject.upTo(upToHere).largest());
    }

    private ArrayList<Integer> knownGoodFibSequenceAlgorithm(Integer upToHere) {
        ArrayList<Integer> fibonocciSequence = new ArrayList();
        fibonocciSequence.add(new Integer(0));
        fibonocciSequence.add(new Integer(1));
        while (fibonocciSequence.get(fibonocciSequence.size() - 1) < upToHere) {
            fibonocciSequence.add(fibonocciSequence.get(fibonocciSequence.size() - 1) + fibonocciSequence.get(fibonocciSequence.size() - 2));
        }
        fibonocciSequence.remove(fibonocciSequence.size() - 1);
        return fibonocciSequence;
    }

    private Integer knownGoodLargestAlgorithm(List<Integer> integerList){
        Integer largest = new Integer(0);
        for(Integer integer : integerList){
            if(integer.compareTo(largest) == 1){
                largest = integer;
            }
        }
        return largest;
    }

}
