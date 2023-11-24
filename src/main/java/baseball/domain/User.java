package baseball.domain;

import java.util.List;

public class User {
    UserNumbers userNumbers;

    public User(UserNumbers userNumbers) {
        this.userNumbers = userNumbers;
    }

    public UserNumbers getUserNumbers() {
        return userNumbers;
    }
}
