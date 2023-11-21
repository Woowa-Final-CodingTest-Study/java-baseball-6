package baseball.model;

public enum Restart {
    RESTART(1),
    TERMINATE(2);

    public int value;

    Restart(int value) {
        this.value = value;
    }
}
