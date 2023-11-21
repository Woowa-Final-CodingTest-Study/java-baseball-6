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
            BaseballNumber answerNumber = BaseballNumber.generateRandomNumber();

            outputView.printStartGame();
            outputView.notifyInputNumber();
            List<Integer> number = inputVIew.readNumber();

            BaseballNumber baseballNumber = new BaseballNumber(number);
            BaseballResult result = BaseballNumber.compare(baseballNumber, answerNumber);
            outputView.printResult(result);
        }
    }
}
