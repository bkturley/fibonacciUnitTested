package interviewQuestion;

import java.util.ArrayList;

public class FibonnociSequenceGenerator {

    public ArrayList<Integer> getFibonnociSequenceUpTo(Integer upToHere) {
        ArrayList<Integer> fibonnociSequence = new ArrayList();
        fibonnociSequence.add(new Integer(0));
        fibonnociSequence.add(new Integer(1));
        while (fibonnociSequence.get(fibonnociSequence.size()-1) < upToHere) {            
            fibonnociSequence.add(fibonnociSequence.get(fibonnociSequence.size()-1) + fibonnociSequence.get(fibonnociSequence.size()-2));
        }
        fibonnociSequence.remove(fibonnociSequence.size()-1);
        return fibonnociSequence;
    }
}
