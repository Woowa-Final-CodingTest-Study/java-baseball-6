package baseball.domain;

public class BallStrikeCount {
    private final int ballCount;
    private final int strikeCount;

    public BallStrikeCount(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}
