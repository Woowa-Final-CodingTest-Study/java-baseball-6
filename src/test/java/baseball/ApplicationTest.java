package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @DisplayName("실패: 잘못된 길이")
    @ParameterizedTest
    @ValueSource(strings = {"12", "1234"})
    void 예외_테스트_잘못된_숫자_길이(String input) {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("실패: 잘못된 형식")
    @ParameterizedTest
    @ValueSource(strings = {"\n", " ", "1 2", "12 ", "123 "})
    void 예외_테스트_잘못된_형식(String input) {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("실패: 중복 숫자")
    @ParameterizedTest
    @ValueSource(strings = {"111", "112", "565"})
    void 예외_테스트_중복_숫자(String input) {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("실패: 0이 포함된 숫자")
    @ParameterizedTest
    @ValueSource(strings = {"110", "606", "046"})
    void 예외_테스트_0이_포함된_숫자(String input) {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("실패: 잘못된 재시작 입력")
    @Test
    void 예외_테스트_잘못된_재시작_입력() {
        assertThatThrownBy(() -> assertRandomNumberInRangeTest(
                () -> runException("246", "135", "1", "597", "589", "3"),
                1, 3, 5, 5, 8, 9)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
