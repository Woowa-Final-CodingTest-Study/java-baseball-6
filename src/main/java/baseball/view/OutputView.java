package baseball.view;

import baseball.model.BaseballResult;

public class OutputView {
    private static OutputView outputView;

    private OutputView() {
    }

    public static OutputView getInstance() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public void printStartGame() {
        println("숫자 야구 게임을 시작합니다.");
    }

    public void notifyInputNumber() {
        print("숫자를 입력해주세요 : ");
    }

    public void printResult(BaseballResult result) {
        println(result.toString());
    }

    public void printGameComplete() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void notifyInputRestart() {
        print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private void print(String message) {
        System.out.print(message);
    }

    private void println(String message) {
        System.out.println(message);
    }
}
