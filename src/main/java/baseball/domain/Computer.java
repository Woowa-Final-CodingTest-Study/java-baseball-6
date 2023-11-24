package baseball.domain;

import java.util.List;

public class Computer {
    private List<Integer> randomNumbers;

    public Computer(List<Integer> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public BallStrikeCount calculateBallCount(UserNumbers userNumbers) {
        int ballCount = 0;
        int strikeCount = 0;

        List<Integer> userNums = userNumbers.getUserNumbers();

        for (int i = 0; i < randomNumbers.size(); i++) {
            int computerNum = randomNumbers.get(i);
            int userNum = userNums.get(i);

            if (computerNum == userNum) {
                strikeCount++;
            }

            if (userNums.contains(computerNum) && computerNum != userNum) {
                ballCount++;
            }
        }
        return new BallStrikeCount(ballCount, strikeCount);
    }

    public void printComputerNumbers() {
        System.out.println("컴퓨터의 숫자: " + randomNumbers);
    }
}
