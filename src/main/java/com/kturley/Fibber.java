package com.kturley;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.PrintStream;
import java.util.List;

@Singleton
class Fibber {

    @Inject
    FibonnociSequenceGenerator fibonnociSequenceGenerator;
    @Inject
    StopWatch stopWatch;
    @Inject
    SumOfAllMultiplesAdder sumOfAllMultiplesAdder;

    PrintStream printStream = System.out;

    void run(String[] args) {

        Integer upperLimit;
        try {
            upperLimit = getUpperLimit(args);
            int evenMultiple = 2;
            reportSumOfAllMultiplesInAFibonacciSequenceUpTo(upperLimit, evenMultiple);
            reportCalculationTime(stopWatch);
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

    private int reportSumOfAllMultiplesInAFibonacciSequenceUpTo(Integer upperLimit, int multiple) {
        int answer = getSumOfEvenNumbers(fibonnociSequenceGenerator.getFibonnociSequenceUpTo(upperLimit), sumOfAllMultiplesAdder, multiple);
        System.out.println("Sum of all even Fibonacci up to " + upperLimit + ": " + answer);
        return answer;
    }

    private long reportCalculationTime(StopWatch stopWatch) {
        long calculationTime = stopWatch.getElapsedTimeNanoSeconds()/1000000;
        System.out.println("Calculation Time: " + calculationTime + " MilliSeconds.");
        return calculationTime;
    }

    private static int getSumOfEvenNumbers(List<Integer> addUpMyEvenNumbers, SumOfAllMultiplesAdder sumOfAllMultiplesAdder, int multiple) {
        return sumOfAllMultiplesAdder.getSumOfAllMultiplesOf(addUpMyEvenNumbers, multiple);
    }

}
