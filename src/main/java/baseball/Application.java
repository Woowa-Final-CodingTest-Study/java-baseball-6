package baseball;

import baseball.controller.Controller;
import baseball.domain.GameService;
import baseball.domain.RandomNumberGenerator;
import baseball.view.InputView;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new GameService(new InputView(), new RandomNumberGenerator()));
        controller.run();
    }
}
