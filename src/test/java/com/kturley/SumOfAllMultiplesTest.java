
package com.kturley;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SumOfAllMultiplesTest {

    private SumOfAllMultiples testSubject;

    private static List<Integer> integerList;

    @BeforeClass
    public static void generateTestData(){
        integerList = new ArrayList<>();
        for (int count = 0; count < 9999; count++) {
            integerList.add(count);
        }
    }

    @Before
    public void setup(){
        testSubject = new SumOfAllMultiples();
    }

    @Test
    public void testGetOfIn() {
        for(Integer integer : integerList){
            int expectedResult = knownGoodAlgorithm(integerList, integer);
            int testResult = testSubject.of(integer).in(integerList).value();
            assertEquals(expectedResult, testResult);
        }
    }

    @Test
    public void testGetInOf() {
        for(Integer integer : integerList){
            int expectedResult = knownGoodAlgorithm(integerList, integer);
            int testResult = testSubject.in(integerList).of(integer).value();
            assertEquals(expectedResult, testResult);
        }
    }

    @Test
    public void testOrderEquivalence(){
        for(Integer integer : integerList){
            assertEquals(testSubject.in(integerList).of(integer).value(), testSubject.of(integer).in(integerList).value());
        }

    }

    private int knownGoodAlgorithm(List<Integer> integerList, int modulus) {
        int sumOfEvenNumbers = 0;
        if(modulus>0){
            for (int i = 0; i < integerList.size(); i++) {
                Integer amIEven = integerList.get(i);
                boolean numberIsEven = (amIEven % modulus == 0);
                if (numberIsEven) {
                    sumOfEvenNumbers += amIEven;
                }
            }
        }
        return sumOfEvenNumbers;
    }

}
