package baseball.controller;

import baseball.domain.BallStrikeCount;
import baseball.domain.Computer;
import baseball.domain.RandomNumberGenerator;
import baseball.domain.User;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Controller {
    public static final String RESTART = "1";
    public static final String EXIT = "2";

    InputView inputView = new InputView();
    RandomNumberGenerator generator = new RandomNumberGenerator();

    public void run() {
        start();
        repeatGame();
    }

    public void start() {
        OutputView.printStartGame();
    }

    public void repeatGame() {
        Computer computer = generator.play();
        computer.printComputerNumbers();
        BallStrikeCount ballStrikeCount;
        do {
            User userNumbers = inputView.getUserInput();
            ballStrikeCount = computer.calculateBallCount(userNumbers);
            OutputView.printResult(ballStrikeCount);
        } while (ballStrikeCount.getStrikeCount() != 3);
        OutputView.printGameOver();
        showEnding();
    }

    public void showEnding() {
        OutputView.printEnding();
        String answer = InputView.askRestartOrExit();
        if (answer.equals(RESTART)) {
            repeatGame();
        }
    }
}
