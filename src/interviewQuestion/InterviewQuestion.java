
/*
 Interview Querstion:
 Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
 */

package interviewQuestion;

import java.util.ArrayList;
import java.util.List;

public class InterviewQuestion {

    public static void main(String[] args) {

        StopWatch stopWatch = new StopWatch();

        reportAnswer();

        reportCalculationTime(stopWatch);
                    
    }
    
    private static void reportAnswer() {
        System.out.println("Answer: " + getSumOfEvenNumbers(getFibonnociSequenceUpToFourMillion()));
    }
    
    private static void reportCalculationTime(StopWatch stopWatch){
                System.out.println("Calculation Time: " + stopWatch.getElapsedTimeNanoSeconds() + " NanoSeconds.");
    }
    
    private static ArrayList<Integer> getFibonnociSequenceUpToFourMillion() {
        FibonnociSequenceGenerator fibonnociSequenceGenerator = new FibonnociSequenceGenerator();
        return fibonnociSequenceGenerator.getFibonnociSequenceUpTo(4000000);
    }

    private static int getSumOfEvenNumbers(List<Integer> addUpMyEvenNumbers) {
        EvenNumberAdder evenNumberAdder = new EvenNumberAdder();
        return evenNumberAdder.getSumOfEvenContent(addUpMyEvenNumbers);
    }

}