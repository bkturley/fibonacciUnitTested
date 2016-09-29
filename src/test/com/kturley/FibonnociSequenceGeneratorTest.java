package com.kturley;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class FibonnociSequenceGeneratorTest {

    public FibonnociSequenceGeneratorTest() {
    }

    @Test
    public void testGetFibonnociSequenceUpTo_999999() {
        Integer upToHere = 999999;
        FibonacciSequenceGenerator instance = new FibonacciSequenceGenerator();
        ArrayList<Integer> expResult = getFibonnociSequenceUpTo(upToHere);
        ArrayList<Integer> result = instance.getFibonnociSequenceUpTo(upToHere);
        assertEquals(expResult, result);
    }

    private ArrayList<Integer> getFibonnociSequenceUpTo(Integer upToHere) {
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
