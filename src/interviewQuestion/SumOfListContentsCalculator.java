
package interviewQuestion;

import java.util.Iterator;
import java.util.List;

public class SumOfListContentsCalculator {
    public Integer getSum(List<Integer> getTheSumOfMyContents){
        Integer returnMe = new Integer(0);
        Iterator<Integer> iterator = getTheSumOfMyContents.iterator();
        while(iterator.hasNext()){
            returnMe += iterator.next();
        }        
        return returnMe;
    }
}
