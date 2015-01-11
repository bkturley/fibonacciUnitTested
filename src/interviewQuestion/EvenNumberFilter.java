
package interviewQuestion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EvenNumberFilter {
    
    public List getEvenNumbersFromList(List<Integer> getMyEvenNumbers){
        ArrayList<Integer> returnMe = new ArrayList();
        Iterator<Integer> iterator = getMyEvenNumbers.iterator();
        
        while(iterator.hasNext()){
            Integer nextValue = iterator.next();
            boolean nextValueIsEven = nextValue % 2 ==0;
            if(nextValueIsEven){
                returnMe.add(nextValue);
            }                
        }
        
        return returnMe;
    }
    
}
