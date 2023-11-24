package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    List<Integer> randomNumbers = new ArrayList<>();

    public Computer play() {
        this.randomNumbers = new ArrayList<>(); // 추가
        return new Computer(generateRandomNumbers());
    }

    private List<Integer> generateRandomNumbers() {
        do {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            addUniqueNumbers(randomNumber);
        }
        while (randomNumbers.size() < 3);
        return randomNumbers;
    }

    private void addUniqueNumbers(int randomNumber) {
        if (!randomNumbers.contains(randomNumber)) {
            randomNumbers.add(randomNumber);
        }
    }
}
