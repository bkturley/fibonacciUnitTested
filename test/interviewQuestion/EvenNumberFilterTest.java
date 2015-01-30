package interviewQuestion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


/**
 *
 * @author bkturley
 */
public class EvenNumberFilterTest {

    public EvenNumberFilterTest() {
    }

    @Test
    public void testGetEvenNumbersFromList_0To999999() {
        List<Integer> getMyEvenNumbers = getList0To999999();;

        EvenNumberFilter instance = new EvenNumberFilter();
        List expResult = getEvenNumbersFromList(getMyEvenNumbers);
        List result = instance.getEvenNumbersFromList(getMyEvenNumbers);
        assertEquals(expResult, result);

    }

    @Test
    public void testGetEvenNumbersFromList_Neg999999To999999() {
        List<Integer> getMyEvenNumbers = getListNeg999999To999999();;
        EvenNumberFilter evenNumberFilter = new EvenNumberFilter();
        List expResult = getEvenNumbersFromList(getMyEvenNumbers);
        List result = evenNumberFilter.getEvenNumbersFromList(getMyEvenNumbers);
        assertEquals(expResult, result);
    }
    
    
    private List<Integer> getEvenNumbersFromList(List getMyEvens) {
        List<Integer> returnMe = new ArrayList<>();
        Iterator<Integer> iterator = getMyEvens.iterator();
        while(iterator.hasNext()){
            Integer currentValue = iterator.next();
            boolean counterIsOddNumber = (currentValue % 2 == 0);
            if (counterIsOddNumber) {
                returnMe.add(currentValue);
            }
        }
        return returnMe;
    }
    
    private List<Integer> getList0To999999() {
        List<Integer> returnMe = new ArrayList<>();
        for (int i = 0; i < 999999; i++) {
            returnMe.add(i);
        }
        return returnMe;
    }
    
    private List<Integer> getListNeg999999To999999() {
        List<Integer> returnMe = new ArrayList<>();
        for (int i = -999999; i < 999999; i++) {
            returnMe.add(i);
        }
        return returnMe;
    }


}
