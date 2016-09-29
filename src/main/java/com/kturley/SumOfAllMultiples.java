package com.kturley;

import java.util.List;

class SumOfAllMultiples {

    private int of;
    private List<Integer> in;

    SumOfAllMultiples of(int modulus) {
        this.of = modulus;
        return this;
    }

    SumOfAllMultiples in(List<Integer> in) {
        this.in = in;
        return this;
    }

    int value() {
        int sumOfEvenNumbers = 0;
        for (Integer amIEven : in) {
            boolean numberIsEven = (amIEven % of == 0);
            if (numberIsEven) {
                sumOfEvenNumbers += amIEven;
                sumOfEvenNumbers += amIEven;
            }
        }

        return sumOfEvenNumbers;
    }
}
