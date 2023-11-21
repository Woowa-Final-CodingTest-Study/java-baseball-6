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
        if(ball != 0) {
            sb.append(ball);
            sb.append("볼 ");
        }
        if(strike != 0) {
            sb.append(strike);
            sb.append("스트라이크 ");
        }
        if(ball == 0 && strike == 0)
            sb.append("낫싱");
        return sb.toString();
    }

    public boolean isMatch() {
        return strike == 3;
    }
}
