package baseball.model;

public class BaseballResult {
    private int ball;
    private int strike;

    public void incrementBall() {
        ball++;
    }

    public void incrementStrike() {
        strike++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (ball != 0) {
            appendBall(sb);
        }
        if (strike != 0) {
            if (sb.length() != 0)
                sb.append(" ");
            appendStrike(sb);
        }
        if (ball == 0 && strike == 0) {
            appendNothing(sb);
        }
        return sb.toString();
    }

    private void appendBall(StringBuilder sb) {
        sb.append(ball);
        sb.append("볼");
    }

    private void appendStrike(StringBuilder sb) {
        sb.append(strike);
        sb.append("스트라이크");
    }

    private void appendNothing(StringBuilder sb) {
        sb.append("낫싱");
    }

    public boolean isMatch() {
        return strike == 3;
    }
}
