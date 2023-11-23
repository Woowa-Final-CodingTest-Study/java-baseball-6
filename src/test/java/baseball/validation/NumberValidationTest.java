package baseball.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class NumberValidationTest {

    private NumberValidation numberValidation;

    @BeforeEach
    void setUp() {
        numberValidation = new NumberValidation();
    }

    @DisplayName("아무값을 입력하지 않는 경우 에러 발생")
    @Test
    void inputNull() {
        String input = "";

        assertThatThrownBy(() -> numberValidation.validateNull(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 int의 범위를 벗어나는 경우 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"11111111111111111", "2222222222222"})
    void inputOverRangeOfInteger(String input) {
        assertThatThrownBy(() -> numberValidation.validateIntRange(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값의 길이가 3이 아닌 경우 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "12"})
    void inputOutOfLength(String input) {
        assertThatThrownBy(() -> numberValidation.validateInputLength(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값에 숫자가 아닌 다른 문자를 사용한 경우 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"r12", "%12", " 34"})
    void inputOtherCharacters(String input) {
        assertThatThrownBy(() -> numberValidation.validateInputForm(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 숫자를 입력한 경우 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"112", "399"})
    void inputDuplicateNumber(String input) {
        assertThatThrownBy(() -> numberValidation.validateDuplicateNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1 또는 2를 입력하지 않은 경우 에러 발생")
    @Test
    void inputWrongNumber() {
        String input = "3";

        assertThatThrownBy(() -> numberValidation.validateReStartNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}