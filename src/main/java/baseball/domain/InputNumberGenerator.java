package baseball.domain;

import java.util.HashSet;
import java.util.Set;

public class InputNumberGenerator {

    public String getUserInput(String input) {
        validateInputLength(input);
        validateDuplicateNumbers(input);

        return input;
    }

    public void validateInputLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public void validateDuplicateNumbers(String input) {
        Set<String> numbers = new HashSet<>();

        for (String number : input.split("")) {
            if (!numbers.add(number)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void validateReStartNumber(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException();
        }
    }

}
