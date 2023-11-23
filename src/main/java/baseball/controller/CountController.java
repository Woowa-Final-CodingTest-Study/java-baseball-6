package baseball.controller;

import baseball.util.Count;
import baseball.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountController {

    OutputView outputView = new OutputView();

    public boolean calculateCount(List<Integer> computerNumbers, String input) {
        List<Integer> userNumbers = Arrays.stream(input.split(""))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        Count count = generateCount(computerNumbers, userNumbers);

        outputView.printCount(count.getStrike(), count.getBall());
        if (checkStrikeCount(count.getStrike())) {
            return true;
        }
        return false;
    }

    public Count generateCount(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < userNumbers.size(); i++) {
            int computerNumber = computerNumbers.get(i);
            int userNumber = userNumbers.get(i);

            if(computerNumber == userNumber) {
                strike++;
                continue;
            }
            if(computerNumbers.contains(userNumber)){
                ball++;
            }
        }
        return new Count(strike, ball);
    }

    public boolean checkStrikeCount(int strike) {
        if (strike == 3) {
            outputView.printGameOver();
            return true;
        }
        return false;
    }
}
