package baseball.domain;

import baseball.view.InputView;
import baseball.view.OutputView;

public class GameService {
    public static final String RESTART = "1";
    public static final String EXIT = "2";

    InputView inputView;
    RandomNumberGenerator generator;

    public GameService(InputView inputView, RandomNumberGenerator generator) {
        this.inputView = inputView;
        this.generator = generator;
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
