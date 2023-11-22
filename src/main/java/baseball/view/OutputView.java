package baseball.view;

import baseball.constant.CountConstant;
import baseball.constant.MessageConstant;

public class OutputView {

    public void printGameStart() {
        System.out.println(MessageConstant.GAME_START_MESSAGE.getMessage());
    }

    public void printInputNumber() {
        System.out.print(MessageConstant.INPUT_NUMBER_MESSAGE.getMessage());
    }

    public void printCount(int strike, int ball) {
        if (strike == 0) {
            System.out.println();
            System.out.printf(CountConstant.BALL.getCount(), ball);
            return;
        }
        if (ball == 0) {
            System.out.println();
            System.out.printf(CountConstant.STRIKE.getCount(), strike);
            return;
        }
        System.out.println();
        System.out.printf(CountConstant.BALL_STRIKE.getCount(), ball, strike);
    }

    public void printGameOver() {
        System.out.println();
        System.out.println(MessageConstant.GAME_OVER_MESSAGE.getMessage());
    }
}
