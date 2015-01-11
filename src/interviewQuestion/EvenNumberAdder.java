
package interviewQuestion;

import java.util.List;

class EvenNumberAdder {

    int getSumOfEvenContent(List<Integer> addUpMyEvenNumbers) {
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
