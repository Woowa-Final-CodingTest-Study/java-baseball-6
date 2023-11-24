package baseball.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @DisplayName("아무값을 입력하지 않는 경우 에러 발생")
    @Test
    void inputNull() {
        String input = "";

        assertThatThrownBy(() -> inputView.validateNull(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 int의 범위를 벗어나는 경우 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"11111111111111111", "2222222222222"})
    void inputOverRangeOfInteger(String input) {
        assertThatThrownBy(() -> inputView.validateIntRange(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값에 숫자가 아닌 다른 문자를 사용한 경우 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"r12", "%12", " 34"})
    void inputOtherCharacters(String input) {
        assertThatThrownBy(() -> inputView.validateInputForm(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}