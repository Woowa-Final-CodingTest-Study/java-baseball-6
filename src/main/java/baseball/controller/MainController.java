package baseball.controller;

import baseball.domain.Count;
import baseball.domain.CountCalculator;
import baseball.domain.ComputerNumberGenerator;
import baseball.domain.InputNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class MainController {

    ComputerNumberGenerator computerNumberGenerator = new ComputerNumberGenerator();
    CountCalculator countCalculator = new CountCalculator();
    InputNumberGenerator inputNumberGenerator = new InputNumberGenerator();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void startGame() {
        outputView.printGameStart();

        compareNumbers();
    }

    public void compareNumbers() {
        List<Integer> computerNumbers = computerNumberGenerator.createComputerNumbers();
        while (true) {
            outputView.printInputNumber();
            String input = inputNumberGenerator.getUserInput(inputView.readInput());

            if (checkContinueGame(countCalculator.calculateCount(computerNumbers, input))) {
                outputView.printGameOver();
                inputFinishOrReGame();
                break;
            }
        }
    }

    public boolean checkContinueGame(Count count) {
        outputView.printCount(count.getStrike(), count.getBall());
        return Count.checkStrikeCount(count);
    }

    public void inputFinishOrReGame() {
        outputView.printAskReStart();
        String input = inputView.readInput();
        inputNumberGenerator.validateReStartNumber(input);

        if (input.equals("1")) {
            compareNumbers();
        }
    }
}
