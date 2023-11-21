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
        if (input.length() != 3)
            throw new IllegalArgumentException();
        List<Integer> number = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String s = input.substring(i, i+1);
            int n = Integer.parseInt(s);
            number.add(n);
        }
        return number;
    }
}
