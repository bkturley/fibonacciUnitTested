package interviewQuestion;

import java.io.PrintStream;
import java.util.List;

class Program {

    public Program() {
    }

    public void run(String[] args) {
        run(args, new StopWatch(), new FibonnociSequenceGenerator(), new SumOfAllMultiplesAdder(), System.out);
    }

    void run(String[] args,
            StopWatch stopWatch,
            FibonnociSequenceGenerator fibonnociSequenceGenerator,
            SumOfAllMultiplesAdder sumOfAllMultiplesAdder,
            PrintStream printStream) {

        Integer upperLimit = null;
        try {
            upperLimit = getUpperLimit(args);
            int evenMultiple = 2;
            reportSumOfAllMultiplesInAFibonacciSequenceUpTo(fibonnociSequenceGenerator, sumOfAllMultiplesAdder, upperLimit, evenMultiple);
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

    private static int reportSumOfAllMultiplesInAFibonacciSequenceUpTo(FibonnociSequenceGenerator fibonnociSequenceGenerator, SumOfAllMultiplesAdder sumOfAllMultiplesAdder, Integer upperLimit, int multiple) {
        int answer = getSumOfEvenNumbers(fibonnociSequenceGenerator.getFibonnociSequenceUpTo(upperLimit), sumOfAllMultiplesAdder, multiple);
        System.out.println("Sum of all multiples of " + multiple + " Fibonacci up to " + upperLimit + ": " + answer);
        return answer;
    }

    private static long reportCalculationTime(StopWatch stopWatch) {
        long calculationTime = stopWatch.getElapsedTimeNanoSeconds()/1000000;
        System.out.println("Calculation Time: " + calculationTime + " MilliSeconds.");
        return calculationTime;
    }

    private static int getSumOfEvenNumbers(List<Integer> addUpMyEvenNumbers, SumOfAllMultiplesAdder sumOfAllMultiplesAdder, int multiple) {
        return sumOfAllMultiplesAdder.getSumOfAllMultiplesOf(addUpMyEvenNumbers, multiple);
    }

}
