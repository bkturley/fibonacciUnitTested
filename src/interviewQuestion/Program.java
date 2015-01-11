
package interviewQuestion;

import java.util.ArrayList;
import java.util.List;

class Program {

    public Program() {
    }

    public int run(String[] args) {                
        return run(args, new StopWatch(), new FibonnociSequenceGenerator(), new EvenNumberAdder());
    }
    
    int run(String[] args,
            StopWatch stopWatch,
            FibonnociSequenceGenerator fibonnociSequenceGenerator,
            EvenNumberAdder evenNumberAdder){
        
        int returnMe =  reportAnswer(fibonnociSequenceGenerator, evenNumberAdder);

        reportCalculationTime(stopWatch);
        
        return returnMe;
    }

    private static int reportAnswer(FibonnociSequenceGenerator fibonnociSequenceGenerator, EvenNumberAdder evenNumberAdder) {
        int answer = getSumOfEvenNumbers(getFibonnociSequenceUpToFourMillion(fibonnociSequenceGenerator), evenNumberAdder);
        System.out.println("Answer: " + answer);
        return answer;
    }

    private static long reportCalculationTime(StopWatch stopWatch) {
        long calculationTime = stopWatch.getElapsedTimeNanoSeconds();
        System.out.println("Calculation Time: " + calculationTime + " NanoSeconds.");
        return calculationTime;
    }

    private static ArrayList<Integer> getFibonnociSequenceUpToFourMillion(FibonnociSequenceGenerator fibonnociSequenceGenerator) {
        return fibonnociSequenceGenerator.getFibonnociSequenceUpTo(4000000);
    }

    private static int getSumOfEvenNumbers(List<Integer> addUpMyEvenNumbers, EvenNumberAdder evenNumberAdder) {
        return evenNumberAdder.getSumOfEvenContent(addUpMyEvenNumbers);
    }

}
