package baseball.domain;

import static baseball.util.constants.BALL;
import static baseball.util.constants.BASEBALL_NUMBER_LENGTH;
import static baseball.util.constants.NOTHING;
import static baseball.util.constants.STRIKE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Baseball {
    private List<String> computerNum;

    public Baseball() {
        this.computerNum = pickComputerNum();
    }

    private List<String> pickComputerNum() {
        List<String> computerNum = new ArrayList<>();
        while (computerNum.size() < BASEBALL_NUMBER_LENGTH) {
            String randomNum = Integer.toString(Randoms.pickNumberInRange(1, 9));
            if (!computerNum.contains(randomNum)) {
                computerNum.add(randomNum);
            }
        }
        return computerNum;
    }

    public String getResult(int inputNum) {
        String result = "";

        int[] countResult = countStrikeBall(inputNum);
        int strike = countResult[0];
        int ball = countResult[1];

        if (ball != 0) {
            result += ball + BALL + " ";
        }
        if (strike != 0) {
            result += strike + STRIKE;
        }
        if (result.isEmpty()) {
            result += NOTHING;
        }
        return result;
    }

    private boolean isStrike(int index, String targetNum) {
        return targetNum.equals(computerNum.get(index));
    }

    private boolean isBall(String targetNum) {
        return computerNum.contains(targetNum);
    }

    private int[] countStrikeBall(int input) {
        int[] result = new int[2];

        String userNum = Integer.toString(input);
        for (int i = 0; i < BASEBALL_NUMBER_LENGTH; i++) {
            String targetNum = userNum.substring(i, i + 1);
            if (isStrike(i, targetNum)) {
                result[0]++;
                continue;
            }
            if (isBall(targetNum)) {
                result[1]++;
            }
        }
        return result;
    }

    public static boolean isCorrect(String result) {
        return result.equals(BASEBALL_NUMBER_LENGTH + STRIKE);
    }

}
