
package com.kturley;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class SumOfAllMultiplesAdderTest {

    public SumOfAllMultiplesAdderTest() {
    }

    @Test
    public void testGetSumOfEvenContent() {
        SumOfAllMultiplesAdder evenNumberAdder = new SumOfAllMultiplesAdder();
        int expectedResult = getSumOfEvenContent(getContent());
        int testResult = evenNumberAdder.getSumOfAllMultiplesOf(getContent(), 2);
        assertEquals(expectedResult, testResult);
    }

    private List<Integer> getContent() {
        ArrayList<Integer> returnMe = new ArrayList<Integer>();
        for (int count = 0; count < 999999; count++) {
               returnMe.add(count);
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
