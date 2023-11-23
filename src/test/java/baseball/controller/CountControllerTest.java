package baseball.controller;

import baseball.util.Count;
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

class CountControllerTest {

    private CountController countController;

    @BeforeEach
    void setUp() {
        countController = new CountController();
    }

    @DisplayName("카운트 기능을 제대로 수행하는지 확인")
    @ParameterizedTest
    @MethodSource("provideNumbers")
    void generateCorrectCount(List<Integer> computerNumbers, List<Integer> userNumbers, int strike, int ball) {
        Count result = countController.generateCount(computerNumbers, userNumbers);
        Count answer = new Count(strike, ball);

        assertThat(result).usingRecursiveComparison().isEqualTo(answer);
    }

    public static Stream<Arguments> provideNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 3, 2), 1, 2),
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), 0, 0)
        );
    }

    @DisplayName("3스트라이크 인지에 따른 true 또는 false를 반환하는지 확인")
    @ParameterizedTest
    @MethodSource("provideCompareNumbers")
    void checkTrueOrFalse(List<Integer> computerNumbers, String input, boolean answer) {
        boolean result = countController.calculateCount(computerNumbers, input);

        assertThat(result).isEqualTo(answer);
    }

    public static Stream<Arguments> provideCompareNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), "123", true),
                Arguments.of(Arrays.asList(4, 5, 6), "457", false)
        );
    }
}