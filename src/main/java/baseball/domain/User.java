package baseball.domain;

import java.util.List;

public class User {
    List<Integer> userNumbers;

    public User(List<Integer> userNumbers) {
        this.userNumbers = userNumbers;
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }
}
