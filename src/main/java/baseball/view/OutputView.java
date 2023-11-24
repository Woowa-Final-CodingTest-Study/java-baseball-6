package baseball.view;

import static baseball.constant.CountConstant.*;
import static baseball.constant.MessageConstant.*;

public class OutputView {
    private final String LINE_SEPARATOR = System.lineSeparator();

    public void printGameStart() {
        GAME_START_MESSAGE.print(LINE_SEPARATOR);
    }

    public void printInputNumber() {
        INPUT_NUMBER_MESSAGE.print();
    }

    public void printCount(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println(NOTHING.getCount());
            return;
        }
        if (strike == 0) {
            System.out.printf(BALL.getCount() + LINE_SEPARATOR, ball);
            return;
        }
        if (ball == 0) {
            System.out.printf(STRIKE.getCount() + LINE_SEPARATOR, strike);
            return;
        }
        System.out.printf(BALL_STRIKE.getCount() + LINE_SEPARATOR, ball, strike);
    }

    public void printGameOver() {
        GAME_OVER_MESSAGE.print(LINE_SEPARATOR);
    }

    public void printAskReStart() {
        ASK_RESTART_MESSAGE.print(LINE_SEPARATOR);
    }
}
