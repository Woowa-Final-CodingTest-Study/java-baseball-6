package baseball.constant;

public enum CountConstant {

    NOTHING("낫싱"),
    BALL("%d볼\n"),
    STRIKE("%d스트라이크\n"),
    BALL_STRIKE("%d볼 %d스트라이크\n");

    private final String count;

    CountConstant(String count) {
        this.count = count;
    }

    public String getCount() {
        return count;
    }
}
