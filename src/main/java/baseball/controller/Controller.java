package baseball.controller;

import baseball.domain.GameService;

public class Controller {
    GameService gameService = new GameService();

    public void run() {
        gameService.start();
        gameService.repeatGame();
    }
}
