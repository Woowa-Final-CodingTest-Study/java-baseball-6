package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumber {

    private final List<Integer> numbers;

    public BaseballNumber(List<Integer> numbers) {
        validateDuplicated(numbers);
        validateZero(numbers);
        this.numbers = numbers;
    }

    public static BaseballNumber generateRandomNumber() {
        List<Integer> number = new ArrayList<>();
        while (number.size() < 3) {
            int n = Randoms.pickNumberInRange(1, 9);
            if (number.contains(n))
                continue;
            number.add(n);
        }
        return new BaseballNumber(number);
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

    private void validateZero(List<Integer> numbers) {
        if (numbers.contains(0))
            throw new IllegalArgumentException();
    }

    public static BaseballResult compare(BaseballNumber input, BaseballNumber answer) {
        BaseballResult result = new BaseballResult();

        for (int i = 0, length = input.numbers.size(); i < length; i++) {
            Integer n = input.numbers.get(i);
            if (!answer.numbers.contains(n))
                continue;
            if (i == answer.numbers.indexOf(n)) {
                result.incrementStrike();
                continue;
            }
            result.incrementBall();
        }

        return result;
    }
}
