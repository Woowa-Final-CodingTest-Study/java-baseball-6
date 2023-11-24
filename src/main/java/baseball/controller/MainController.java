package baseball.controller;

import baseball.domain.CountCalculator;
import baseball.domain.ComputerNumberGenerator;
import baseball.validation.NumberValidation;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class MainController {

    private final ComputerNumberGenerator computerNumberGenerator;
    private final CountCalculator countCalculator;

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    NumberValidation numberValidation = new NumberValidation();

    public MainController() {
        computerNumberGenerator = new ComputerNumberGenerator();
        countCalculator = new CountCalculator();
    }

    public void startGame() {
        outputView.printGameStart();

        compareNumbers();
    }

    public void compareNumbers() {
        List<Integer> computerNumbers = computerNumberGenerator.createComputerNumbers();
        while (true) {
            String input = getUserInput();

            if (countCalculator.calculateCount(computerNumbers, input)) {
                outputView.printGameOver();
                inputFinishOrReGame();
                break;
            }
        }
    }

    public String getUserInput() {
        outputView.printInputNumber();
        String input = inputView.readInput();
        numberValidation.validateInputNumber(input);

        return input;
    }

    public void inputFinishOrReGame() {
        outputView.printAskReStart();
        String input = inputView.readInput();
        numberValidation.validateInputReStartNumber(input);

        if (input.equals("1")) {
            compareNumbers();
        }
    }
}
