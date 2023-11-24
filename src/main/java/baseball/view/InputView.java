package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readInput() {
        String input = Console.readLine();
        validateNull(input);
        validateIntRange(input);
        validateInputForm(input);

        return input;
    }

    public void validateNull(String input) {
        if (input.isEmpty()) {
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

    public void validateInputForm(String input) {
        String deleteExceptNumber = input.replaceAll("[0-9]", "");

        if (!deleteExceptNumber.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

}
