package com.kturley;

import javax.inject.Inject;
import java.io.PrintStream;

class Fibber {

    @Inject
    FibonacciSequence fibonacciSequence;
    @Inject
    StopWatch stopWatch;
    @Inject
    SumOfAllMultiples sumOfAllMultiples;

    PrintStream printStream = System.out;

    void run(String[] args) {

        Integer upperLimit;
        try {
            upperLimit = getUpperLimit(args);
            stopWatch.start();
            System.out.println("Sum of all even Fibonacci up to " + upperLimit + ": " + sumOfAllMultiplesInAFibonacciSequenceUpTo(upperLimit, 2));
            reportCalculationTime();
        } catch (NumberFormatException numberFormatException) {
            printStream.println("Invalid upper limit parameter: " + args[0]);
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            printStream.println("Missing upper limit parameter.");
        } catch (ParameterListLengthException ex) {
            printStream.println("Invalid parameter list.");
        }
    }

    private Integer getUpperLimit(String[] args) throws NumberFormatException, ParameterListLengthException, ArrayIndexOutOfBoundsException {
        Integer upperLimit;
        upperLimit = Integer.parseInt(args[0]);
        if (upperLimit < 0) {
            throw new NumberFormatException();
        }
        boolean invalidParameterListLength = args.length != 1;
        if (invalidParameterListLength) {
            throw new ParameterListLengthException();
        }
        return upperLimit;
    }

    private int sumOfAllMultiplesInAFibonacciSequenceUpTo(Integer upperLimit, int multiple) {
        int answer = sumOfAllMultiples.of(multiple).in(fibonacciSequence.upTo(upperLimit)).value();
        return answer;
    }

    private long reportCalculationTime() {
        long calculationTime = stopWatch.getElapsedTimeNanoSeconds();
        System.out.println("Calculation Time: " + calculationTime + " NanoSeconds.");
        return calculationTime;
    }

}
