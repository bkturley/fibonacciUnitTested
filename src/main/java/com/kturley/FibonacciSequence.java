package com.kturley;

import java.util.ArrayList;

public class FibonacciSequence {

    public ArrayList<Integer> upTo(Integer upToHere) {
        ArrayList<Integer> fibonacciSequence = new ArrayList();
        fibonacciSequence.add(new Integer(0));
        fibonacciSequence.add(new Integer(1));
        while (fibonacciSequence.get(fibonacciSequence.size()-1) < upToHere) {
            fibonacciSequence.add(fibonacciSequence.get(fibonacciSequence.size()-1) + fibonacciSequence.get(fibonacciSequence.size()-2));
        }
        fibonacciSequence.remove(fibonacciSequence.size()-1);
        return fibonacciSequence;
    }
}
