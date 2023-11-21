package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumber {

    private final List<Integer> numbers;

    public BaseballNumber(List<Integer> numbers) {
        validateDuplicated(numbers);
        this.numbers = numbers;
    }

    public static List<Integer> generateRandomNumber() {
        List<Integer> number = new ArrayList<>();
        while (number.size() < 3) {
            int n = Randoms.pickNumberInRange(1, 9);
            if (number.contains(n))
                continue;
            number.add(n);
        }
        return number;
    }

    private void validateDuplicated(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            Integer number = numbers.get(i);
            long count = numbers.stream()
                    .filter(n -> n.equals(number))
                    .count();
            if (count != 1)
                throw new IllegalArgumentException();
        }
    }
}
