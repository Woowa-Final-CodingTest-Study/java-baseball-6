package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CountCalculatorTest {

    private CountCalculator countCalculator;

    @BeforeEach
    void setUp() {
        countCalculator = new CountCalculator();
    }

    @DisplayName("카운트 기능을 제대로 수행하는지 확인")
    @ParameterizedTest
    @MethodSource("provideNumbers")
    void generateCorrectCount(List<Integer> computerNumbers, List<Integer> userNumbers, int strike, int ball) {
        Count result = countCalculator.generateCount(computerNumbers, userNumbers);
        Count answer = new Count(strike, ball);

        assertThat(result).usingRecursiveComparison().isEqualTo(answer);
    }

    public static Stream<Arguments> provideNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 3, 2), 1, 2),
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), 0, 0)
        );
    }

    @DisplayName("스트라이크와 볼 카운트가 제대로 수행되는지 확인")
    @ParameterizedTest
    @MethodSource("provideCompareNumbers")
    void checkTrueOrFalse(List<Integer> computerNumbers, String input, Count answer) {
        Count result = countCalculator.calculateCount(computerNumbers, input);

        assertThat(result).usingRecursiveComparison().isEqualTo(answer);
    }

    public static Stream<Arguments> provideCompareNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), "123", new Count(3, 0)),
                Arguments.of(Arrays.asList(4, 5, 6), "457", new Count(2, 0))
        );
    }

    @DisplayName("입력받은 값을 리스트로 반환하는지 확인")
    @Test
    void checkInputToList() {
        String input = "123";
        List<Integer> result = countCalculator.convertInput(input);
        List<Integer> answer = Arrays.asList(1, 2, 3);

        assertThat(result).isEqualTo(answer);
    }
}