package baseball.domain;

import java.util.List;

public class UserNumbers {
    private final List<Integer> userNumbers;

    public UserNumbers(List<Integer> userNumbers) {
        this.userNumbers = userNumbers;
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }
}
