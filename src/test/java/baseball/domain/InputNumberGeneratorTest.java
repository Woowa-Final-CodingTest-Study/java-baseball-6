package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputNumberGeneratorTest {

    private InputNumberGenerator inputNumberGenerator;

    @BeforeEach
    void setUp() {
        inputNumberGenerator = new InputNumberGenerator();
    }

    @DisplayName("입력값의 길이가 3이 아닌 경우 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "12"})
    void inputOutOfLength(String input) {
        assertThatThrownBy(() -> inputNumberGenerator.validateInputLength(input))
                .isInstanceOf(IllegalArgumentException.class);
    }



    @DisplayName("중복된 숫자를 입력한 경우 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"112", "399"})
    void inputDuplicateNumber(String input) {
        assertThatThrownBy(() -> inputNumberGenerator.validateDuplicateNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1 또는 2를 입력하지 않은 경우 에러 발생")
    @Test
    void inputWrongNumber() {
        String input = "3";

        assertThatThrownBy(() -> inputNumberGenerator.validateReStartNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}