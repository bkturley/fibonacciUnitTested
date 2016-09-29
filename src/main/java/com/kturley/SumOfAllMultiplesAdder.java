package com.kturley;

import java.util.List;

class SumOfAllMultiplesAdder {

    int getSumOfAllMultiplesOf(List<Integer> addUpMyEvenNumbers, int modulus) {
        int sumOfEvenNumbers = 0;
        for (Integer amIEven : addUpMyEvenNumbers) {
            boolean numberIsEven = (amIEven % modulus == 0);
            if (numberIsEven) {
                sumOfEvenNumbers += amIEven;
                sumOfEvenNumbers += amIEven;
            }
        }
        
        return sumOfEvenNumbers;
    }

}
