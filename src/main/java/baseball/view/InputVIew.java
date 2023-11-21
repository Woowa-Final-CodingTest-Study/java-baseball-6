package baseball.view;

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
            for (int i = 0; i < 3; i++) {
                String s = input.substring(i, i + 1);
                int n = Integer.parseInt(s);
                numbers.add(n);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return numbers;
    }

    private void validateInputLength(String input) {
        if (input.length() != 3) //TODO: 매직 넘버
            throw new IllegalArgumentException();
    }
}
