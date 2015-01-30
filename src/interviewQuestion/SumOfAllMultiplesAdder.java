
package interviewQuestion;

import java.util.List;

class SumOfAllMultiplesAdder {

    int getSumOfAllMultiplesOf(List<Integer> addUpMyEvenNumbers, int modulus) {
        int sumOfEvenNumbers = 0;
        for (int i = 0; i < addUpMyEvenNumbers.size(); i++) {
            Integer amIEven = addUpMyEvenNumbers.get(i);
            boolean numberIsMultiple = (amIEven % modulus == 0);
            if (numberIsMultiple) {
                sumOfEvenNumbers += amIEven;
            }
        }
        return sumOfEvenNumbers;
    }

}
