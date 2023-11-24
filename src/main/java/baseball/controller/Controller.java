package baseball.controller;

import baseball.domain.GameService;

public class Controller {
    GameService gameService;

    public Controller(GameService gameService) {
        this.gameService = gameService;
    }

    public void run() {
        gameService.start();
        gameService.repeatGame();
    }
}
