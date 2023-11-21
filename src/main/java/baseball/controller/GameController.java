package baseball.controller;

import baseball.model.BaseballNumber;
import baseball.model.BaseballResult;
import baseball.view.InputVIew;
import baseball.view.OutputView;

import java.util.List;

public class GameController {
    private static GameController gameController;
    private final InputVIew inputVIew;
    private final OutputView outputView;

    private GameController(InputVIew inputVIew, OutputView outputView) {
        this.inputVIew = inputVIew;
        this.outputView = outputView;
    }

    public static GameController getInstance(InputVIew inputVIew, OutputView outputView) {
        if (gameController == null) {
            gameController = new GameController(inputVIew, outputView);
        }
        return gameController;
    }

    public void start() {
        while (true) {
            outputView.printStartGame();
            BaseballNumber answerNumber = BaseballNumber.generateRandomNumber();
            boolean isRestart = playGame(answerNumber);
            if (!isRestart)
                break;
        }
    }

    private boolean playGame(BaseballNumber answerNumber) {
        while (true) {
            outputView.notifyInputNumber();
            List<Integer> number = inputVIew.readNumber();
            BaseballNumber baseballNumber = new BaseballNumber(number);

            BaseballResult result = BaseballNumber.compare(baseballNumber, answerNumber);
            outputView.printResult(result);

            if (result.isMatch()) {
                outputView.printGameComplete();
                outputView.notifyInputRestart();
                return inputVIew.readRestart();
            }
        }
    }
}
