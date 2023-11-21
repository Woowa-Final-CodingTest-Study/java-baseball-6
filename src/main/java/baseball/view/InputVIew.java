package baseball.view;

import baseball.model.BaseballNumber;
import baseball.model.Restart;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputVIew {
    private static InputVIew inputVIew;

    private InputVIew() {
    }

    public static InputVIew getInstance() {
        if (inputVIew == null) {
            inputVIew = new InputVIew();
        }
        return inputVIew;
    }

    public List<Integer> readNumber() {
        String input = Console.readLine();
        validateInputLength(input);

        List<Integer> numbers = new ArrayList<>();
        try {
            for (int i = 0; i < BaseballNumber.LENGTH; i++) {
                String s = input.substring(i, i + 1);
                int n = Integer.parseInt(s);
                numbers.add(n);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return numbers;
    }

    public boolean readRestart() {
        String input = Console.readLine();
        try {
            int i = Integer.parseInt(input);
            return isRestart(i);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isRestart(int i) {
        if (i == Restart.RESTART.value)
            return true;
        if (i == Restart.TERMINATE.value)
            return false;
        throw new IllegalArgumentException();
    }

    private void validateInputLength(String input) {
        if (input.length() != BaseballNumber.LENGTH)
            throw new IllegalArgumentException();
    }
}
