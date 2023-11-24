package baseball.view;

import baseball.domain.BallStrikeCount;

public class OutputView {
    public static void printStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printInputRequest() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printResult(BallStrikeCount ballStrikeCount) {
        int ballCount = ballStrikeCount.getBallCount();
        int strikeCount = ballStrikeCount.getStrikeCount();

        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        }

        if (ballCount > 0 && strikeCount > 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }

        if (ballCount > 0 && strikeCount == 0) {
            System.out.println(ballCount + "볼 ");
        }

        if (ballCount == 0 && strikeCount > 0) {
            System.out.println(strikeCount + "스트라이크");
        }
    }

    public static void printGameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printEnding() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
