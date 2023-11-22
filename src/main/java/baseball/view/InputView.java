package baseball.view;

import static baseball.util.constants.BASEBALL_NUMBER_LENGTH;
import static baseball.util.constants.ERROR_DUPLICATED;
import static baseball.util.constants.ERROR_NEED_NUMBER;
import static baseball.util.constants.ERROR_WRONG_INPUT_FORMAT;
import static baseball.util.constants.ERROR_WRONG_LENGTH;
import static baseball.util.constants.ERROR_WRONG_RANGE;
import static baseball.util.constants.EXIT;
import static baseball.util.constants.NEED_REENTERING;
import static baseball.util.constants.RESTART;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {
    public static int readUserNum() {
        try {
            String userNum = Console.readLine();
            validateLength(userNum);
            validateIsUnique(userNum);
            validateRange(userNum);

            return convertStringToInt(userNum);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readUserNum();
        }
    }

    public static String readRestartNum() {
        try {
            String restartNum = Console.readLine();
            validateRestartNum(restartNum);
            return restartNum;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readRestartNum();
        }
    }

    public static void validateIsUnique(String input) {
        List<String> inputNum = Arrays.asList(input.split(""));
        Set<String> unredundantInputNum = new HashSet<>(inputNum);

        if (unredundantInputNum.size() != inputNum.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATED + " " + NEED_REENTERING);
        }
    }

    public static void validateRestartNum(String input) {
        if (!(input.equals(RESTART) || input.equals(EXIT))) {
            throw new IllegalArgumentException(ERROR_WRONG_INPUT_FORMAT + " " + NEED_REENTERING);
        }
    }

    public static void validateLength(String input) {
        if (input.length() != BASEBALL_NUMBER_LENGTH) {
            throw new IllegalArgumentException(ERROR_WRONG_LENGTH + " " + NEED_REENTERING);
        }
    }

    public static void validateRange(String input) {
        for (int i = 0; i < input.length(); i++) {
            char num = input.charAt(i);
            if (num < '1' || num > '9') {
                throw new IllegalArgumentException(ERROR_WRONG_RANGE + " " + NEED_REENTERING);
            }
        }
    }

    public static int convertStringToInt(String num) {
        try {
            return Integer.parseInt(num);

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_NEED_NUMBER + " " + NEED_REENTERING);
        }
    }
}

