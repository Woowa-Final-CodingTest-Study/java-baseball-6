package baseball;

import baseball.controller.GameController;
import baseball.view.InputVIew;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputVIew inputVIew = InputVIew.getInstance();
        OutputView outputView = OutputView.getInstance();
        GameController gameController = GameController.getInstance(inputVIew, outputView);

        gameController.start();
    }
}
