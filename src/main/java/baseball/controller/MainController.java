package baseball.controller;

import baseball.validation.NumberValidation;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class MainController {

    private final NumberController numberController;
    private final CountController countController;

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    NumberValidation numberValidation = new NumberValidation();

    public MainController() {
        numberController = new NumberController();
        countController = new CountController();
    }

    public void startGame() {
        outputView.printGameStart();

        compareNumbers();
    }

    public void compareNumbers() {
        List<Integer> computerNumbers = numberController.createComputerNumbers();
        while (true) {
            outputView.printInputNumber();
            String input = inputView.readInput();
            numberValidation.validateInputNumber(input);

            if (countController.calculateCount(computerNumbers, input)) {
                inputFinishOrReGame();
                break;
            }
        }
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
