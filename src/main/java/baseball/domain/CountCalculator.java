package baseball.domain;

import baseball.view.OutputView;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountCalculator {

    OutputView outputView = new OutputView();

    public boolean calculateCount(List<Integer> computerNumbers, String input) {
        List<Integer> userNumbers = convertInput(input);
        Count count = generateCount(computerNumbers, userNumbers);

        outputView.printCount(count.getStrike(), count.getBall());
        return Count.checkStrikeCount(count);
    }

    public List<Integer> convertInput(String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Count generateCount(List<Integer> computerNumbers, List<Integer> userNumbers) {
        long strike = IntStream.range(0, userNumbers.size())
                .filter(i -> computerNumbers.get(i).equals(userNumbers.get(i)))
                .count();

        long ball = IntStream.range(0, userNumbers.size())
                .filter(i -> !computerNumbers.get(i).equals(userNumbers.get(i))
                        && computerNumbers.contains(userNumbers.get(i)))
                .count();

        return new Count((int) strike, (int) ball);
    }
}
