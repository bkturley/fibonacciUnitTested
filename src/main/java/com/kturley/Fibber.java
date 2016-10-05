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

    private Integer upperLimit;

    void run(String[] args) {
        if(validInput(args)){
            printStream.println(successConsoleOutput());
//            Integer largestFibFound = fibonacciSequence.upTo(upperLimit).largest();
//            printStream.println("Largest Fibonacci number found: " + largestFibFound);
        }else{
            printStream.println(invalidConsoleOutput(args));
        }
    }

    private boolean validInput(String[] args) {
        return invalidConsoleOutput(args).isEmpty();
    }

    private String successConsoleOutput() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Sum of all even Fibonacci up to " + upperLimit + ": ");
        stopWatch.start();
        int sumOfEvenFibs = sumOfAllMultiples.of(2).in(fibonacciSequence.upTo(upperLimit).value()).value();
        long calculationTime = stopWatch.stop();
        stringBuilder.append(sumOfEvenFibs);
        stringBuilder.append(System.getProperty("line.separator"));
        stringBuilder.append("Calculation Time: " + calculationTime + " NanoSeconds.");
        return stringBuilder.toString();
    }

    private String invalidConsoleOutput(String[] args) {
        String inValidInputMessage = "";
        try {
            upperLimit = parseUpperLimitFromCommandLineArgs(args);
        } catch (NumberFormatException numberFormatException) {
            inValidInputMessage = "Invalid upper limit parameter: " + args[0];
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            inValidInputMessage = "Missing upper limit parameter.";
        } catch (ParameterListLengthException ex) {
            inValidInputMessage = "Invalid parameter list.";
        }
        return inValidInputMessage;
    }

    private Integer parseUpperLimitFromCommandLineArgs(String[] args) throws NumberFormatException, ParameterListLengthException, ArrayIndexOutOfBoundsException {
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

}
