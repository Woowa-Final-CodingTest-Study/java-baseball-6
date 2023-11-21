package baseball.controller;

import baseball.view.InputVIew;
import baseball.view.OutputView;

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
    }
}
