package baseball.view;

import static baseball.constant.CountConstant.*;
import static baseball.constant.MessageConstant.*;

public class OutputView {
    private final String LINE_SEPARATOR = System.lineSeparator();
    public void printGameStart() {
        System.out.println(GAME_START_MESSAGE.getMessage());
    }

    public void printInputNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE.getMessage());
    }

    public void printCount(int strike, int ball) {
        if(strike == 0 && ball == 0){
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
        System.out.println(GAME_OVER_MESSAGE.getMessage());
    }

    public void printAskReStart(){
        System.out.println(ASK_RESTART.getMessage());
    }
}
