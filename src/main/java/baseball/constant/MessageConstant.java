package baseball.constant;

public enum MessageConstant {

    GAME_START_MESSAGE("숫자 야구 게임을 시작합니다."),
    INPUT_NUMBER_MESSAGE("숫자를 입력해주세요 : "),
    GAME_OVER_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    ASK_RESTART_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String message;

    MessageConstant(String message) {
        this.message = message;
    }

    public void print() {
        System.out.print(message);
    }

    public void print(String lineSeparator) {
        System.out.print(message + lineSeparator);
    }
}
