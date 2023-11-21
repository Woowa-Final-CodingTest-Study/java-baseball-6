package baseball.view;

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

    private void print(String message) {
        System.out.print(message);
    }

    private void println(String message) {
        System.out.println(message);
    }
}
