package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumberGenerator {

    public List<Integer> createComputerNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int pickRandomNumber = Randoms.pickNumberInRange(1, 9);

            if (randomNumbers.contains(pickRandomNumber)) {
                continue;
            }
            randomNumbers.add(pickRandomNumber);
        }
        return randomNumbers;
    }
}
