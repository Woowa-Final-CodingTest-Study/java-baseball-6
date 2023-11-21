package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
                arguments(List.of(1,2,0), new IllegalArgumentException()),
                arguments(List.of(0,4,9), new IllegalArgumentException())
        );
    }

    @DisplayName("중복된 숫자가 포함된 리스트로 생성할 경우")
    @ParameterizedTest
    @MethodSource("duplicatedInputProvider")
    void fail_constructor_with_duplicated_input(List<Integer> numbers) {
        Assertions.assertThatThrownBy(() -> new BaseballNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0이 포함된 리스트로 생성할 경우")
    @ParameterizedTest
    @MethodSource("zeroContainingInputProvider")
    void fail_constructor_with_zero_containing_input(List<Integer> numbers) {
        Assertions.assertThatThrownBy(() -> new BaseballNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void compare() {
    }

}
