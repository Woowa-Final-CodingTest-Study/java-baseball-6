package baseball.validation;

import java.util.HashSet;
import java.util.Set;

public class NumberValidation {

    public void validateInputNumber(String input) {
        validateNull(input);
        validateIntRange(input);
        validateInputLength(input);
        validateInputForm(input);
        validateDuplicateNumbers(input);
    }

    public void validateInputReStartNumber(String input) {
        validateNull(input);
        validateIntRange(input);
        validateInputForm(input);
        validateReStartNumber(input);
    }

    public void validateNull(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException();
        }
    }

    public void validateIntRange(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException();
        }
    }

    public void validateInputLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public void validateInputForm(String input) {
        String deleteExceptNumber = input.replaceAll("[0-9]", "");

        if (!deleteExceptNumber.isEmpty()) {
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
