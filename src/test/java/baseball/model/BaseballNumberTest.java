package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class BaseballNumberTest {
    public static Stream<Arguments> duplicatedInputProvider() {
        return Stream.of(
                arguments(List.of(1, 2, 2), new IllegalArgumentException()),
                arguments(List.of(6, 3, 6), new IllegalArgumentException())
        );
    }

    public static Stream<Arguments> zeroContainingInputProvider() {
        return Stream.of(
                arguments(List.of(1, 2, 0), new IllegalArgumentException()),
                arguments(List.of(0, 4, 9), new IllegalArgumentException())
        );
    }

    public static Stream<Arguments> SuccessfulInputProvider() {
        return Stream.of(
                arguments(List.of(1, 2, 3)),
                arguments(List.of(3, 4, 7)),
                arguments(List.of(3, 4, 7))
        );
    }

    public static Stream<Arguments> twoNumbersProvider() {
        return Stream.of(
                arguments(new BaseballNumber(List.of(1, 2, 3)), new BaseballNumber(List.of(4, 5, 6)), "낫싱", false),
                arguments(new BaseballNumber(List.of(1, 2, 3)), new BaseballNumber(List.of(1, 7, 2)), "1볼 1스트라이크", false),
                arguments(new BaseballNumber(List.of(3, 4, 5)), new BaseballNumber(List.of(7, 4, 5)), "2스트라이크", false),
                arguments(new BaseballNumber(List.of(6, 3, 7)), new BaseballNumber(List.of(6, 3, 7)), "3스트라이크", true)
        );
    }

    @DisplayName("생성자 - 실패: 중복된 숫자가 포함된 리스트로 생성할 경우")
    @ParameterizedTest
    @MethodSource("duplicatedInputProvider")
    void constructor_fail_with_duplicated_input(List<Integer> numbers) {
        Assertions.assertThatThrownBy(() -> new BaseballNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("생성자 - 실패: 0이 포함된 리스트로 생성할 경우")
    @ParameterizedTest
    @MethodSource("zeroContainingInputProvider")
    void constructor_fail_with_zero_containing_input(List<Integer> numbers) {
        Assertions.assertThatThrownBy(() -> new BaseballNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("생성자 - 성공")
    @ParameterizedTest
    @MethodSource("SuccessfulInputProvider")
    void constructor_success(List<Integer> numbers) {
        Assertions.assertThatNoException().isThrownBy(() -> new BaseballNumber(numbers));
    }

    @DisplayName("입력을 비교하여 올바른 결과 출력")
    @ParameterizedTest
    @MethodSource("twoNumbersProvider")
    void compare(BaseballNumber input, BaseballNumber answer, String resultText, boolean isMatch) {
        BaseballResult result = BaseballNumber.compare(input, answer);
        Assertions.assertThat(result.toString())
                .isEqualTo(resultText);
        Assertions.assertThat(result.isMatch())
                .isEqualTo(isMatch);
    }
}
