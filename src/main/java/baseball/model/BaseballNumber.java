package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumber {
    public static int LENGTH = 3;
    public static int RANGE_MIN = 1;
    public static int RANGE_MAX = 9;
    private final List<Integer> numbers;

    public BaseballNumber(List<Integer> numbers) {
        validateDuplicated(numbers);
        validateZero(numbers);
        this.numbers = numbers;
    }

    public static BaseballNumber generateRandomNumber() {
        List<Integer> number = new ArrayList<>();
        while (number.size() < LENGTH) {
            int n = Randoms.pickNumberInRange(RANGE_MIN, RANGE_MAX);
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

        for (int i = 0; i < LENGTH; i++) {
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
