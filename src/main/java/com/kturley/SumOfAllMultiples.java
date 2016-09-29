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
        for (Integer amIMultiple : in) {
            boolean numberIsMultiple = (amIMultiple % of == 0);
            if (numberIsMultiple) {
                sumOfEvenNumbers += amIMultiple;
            }
        }

        return sumOfEvenNumbers;
    }
}
