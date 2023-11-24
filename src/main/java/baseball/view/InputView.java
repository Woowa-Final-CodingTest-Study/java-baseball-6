package baseball.view;


import baseball.domain.User;
import baseball.domain.UserNumbers;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class InputView {
    public UserNumbers getUserInput() {
        OutputView.printInputRequest();
        String input = Console.readLine();
        validateInteger(input);
        List<Integer> userNumbers = convertStringToList(input);
        validateUserNumbers(userNumbers);
        return new UserNumbers(userNumbers);
    }

    public List<Integer> convertStringToList(String input) {
        List<Integer> userNumbers = new ArrayList<>();
        for (char c : input.toCharArray()) {
            int digit = Character.getNumericValue(c);
            userNumbers.add(digit);
        }
        return userNumbers;
    }

    private void validateUserNumbers(List<Integer> userNumbers) {
        if (!isUnique(userNumbers)) {
            throw new IllegalArgumentException("1");
        }
        if (!isThree(userNumbers)) {
            throw new IllegalArgumentException("2");
        }
        if (!containsOnlyPositiveInt(userNumbers)) {
            throw new IllegalArgumentException("3");
        }
    }

    private void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isUnique(List<Integer> userNumbers) {
        HashSet<Integer> set = new HashSet<>(userNumbers);
        return set.size() == userNumbers.size();
    }

    private boolean isThree(List<Integer> userNumbers) {
        if (userNumbers.size() != 3) {
            return false;
        }
        return true;
    }

    private boolean containsOnlyPositiveInt(List<Integer> userNumbers) {
        if (userNumbers.contains(0)) {
            return false;
        }
        return true;
    }

    public static String askRestartOrExit() {
        String answer = Console.readLine();
        return answer;
    }
}
