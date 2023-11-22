package baseball.view;

import static baseball.util.constants.CORRECT_THREE_NUMBER;
import static baseball.util.constants.PLEASE_INPUT_NUMBER;
import static baseball.util.constants.PLEASE_INPUT_RESTART_OR_EXIT;
import static baseball.util.constants.START_BASEBALL_GAME;

public class OutputView {
    public static void printStart() {
        System.out.println(START_BASEBALL_GAME);
    }

    public static void printRequestNumber() {
        System.out.print(PLEASE_INPUT_NUMBER + " : ");
    }

    public static void printResult(String result) {
        System.out.println(result);
    }

    public static void printEnding() {
        System.out.println(CORRECT_THREE_NUMBER);
    }

    public static void printRequestRestart() {
        System.out.println(PLEASE_INPUT_RESTART_OR_EXIT);
    }
}
