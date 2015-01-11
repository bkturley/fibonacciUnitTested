/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewQuestion;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bkturley
 */
public class EvenNumberAdderTest {

    public EvenNumberAdderTest() {
    }

    @Test
    public void testGetSumOfEvenContent() {
        EvenNumberAdder evenNumberAdder = new EvenNumberAdder();
        int expectedResult = getSumOfEvenContent(getContent());
        int testResult = evenNumberAdder.getSumOfEvenContent(getContent());
        assertEquals(expectedResult, testResult);
    }

    private List<Integer> getContent() {
        ArrayList<Integer> returnMe = new ArrayList<Integer>();
        for (int count = 0; count < 999999; count++) {

        }
        return returnMe;
    }

    private int getSumOfEvenContent(List<Integer> addUpMyEvenNumbers) {
        int sumOfEvenNumbers = 0;
        for (int i = 0; i < addUpMyEvenNumbers.size(); i++) {
            Integer amIEven = addUpMyEvenNumbers.get(i);
            boolean numberIsEven = (amIEven % 2 == 0);
            if (numberIsEven) {
                sumOfEvenNumbers += amIEven;
            }
        }
        return sumOfEvenNumbers;
    }

}
