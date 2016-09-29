package com.kturley;

import java.util.ArrayList;

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
    public void testGetFibonacciSequenceUpTo_999999() {
        Integer upToHere = 999999;
        assertEquals(knownGoodAlgorithm(upToHere), testSubject.upTo(upToHere));
    }

    private ArrayList<Integer> knownGoodAlgorithm(Integer upToHere) {
        ArrayList<Integer> fibonnociSequence = new ArrayList();
        fibonnociSequence.add(new Integer(0));
        fibonnociSequence.add(new Integer(1));
        while (fibonnociSequence.get(fibonnociSequence.size() - 1) < upToHere) {
            fibonnociSequence.add(fibonnociSequence.get(fibonnociSequence.size() - 1) + fibonnociSequence.get(fibonnociSequence.size() - 2));
        }
        fibonnociSequence.remove(fibonnociSequence.size() - 1);
        return fibonnociSequence;
    }

}
