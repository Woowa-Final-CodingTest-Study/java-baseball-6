package baseball.constant;

public enum CountConstant {

    NOTHING("낫싱"),
    BALL("%d볼"),
    STRIKE("%d스트라이크"),
    BALL_STRIKE("%d볼 %d스트라이크");

    private final String count;

    CountConstant(String count) {
        this.count = count;
    }

    public String getCount() {
        return count;
    }
}
