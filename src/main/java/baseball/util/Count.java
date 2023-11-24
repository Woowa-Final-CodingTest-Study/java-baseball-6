package baseball.util;

public class Count {
    private final int strike;
    private final int ball;

    public Count(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public static boolean checkStrikeCount(Count count) {
        return count.getStrike() == 3;
    }
}
