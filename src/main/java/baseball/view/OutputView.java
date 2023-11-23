package baseball.view;

import static baseball.constant.CountConstant.*;
import static baseball.constant.MessageConstant.*;

public class OutputView {

    public void printGameStart() {
        System.out.println(GAME_START_MESSAGE.getMessage());
    }

    public void printInputNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE.getMessage());
    }

    public void printCount(int strike, int ball) {
        if (strike == 0) {
            System.out.printf(BALL.getCount(), ball);
            return;
        }
        if (ball == 0) {
            System.out.printf(STRIKE.getCount(), strike);
            return;
        }
        System.out.printf(BALL_STRIKE.getCount(), ball, strike);
    }

    public void printGameOver() {
        System.out.println(GAME_OVER_MESSAGE.getMessage());
    }

    public void printAskReStart(){
        System.out.println(ASK_RESTART.getMessage());
    }
}
