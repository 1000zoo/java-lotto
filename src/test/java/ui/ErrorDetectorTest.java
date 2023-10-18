package ui;

import lotto.ui.ErrorDetector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErrorDetectorTest {

    @Test
    @DisplayName("숫자가 아닌 문자를 입력했을 때")
    void isCorrectAmount01() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> ErrorDetector.isCorrectAmount("1111z")
        );
    }

    @Test
    @DisplayName("1000 이하의 숫자를 입력했을 때")
    void isCorrectAmount02() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> ErrorDetector.isCorrectAmount("980")
        );
    }

    @Test
    @DisplayName("1000의 배수가 아닌 수를 입력했을 때")
    void isCorrectAmount03() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> ErrorDetector.isCorrectAmount("1300")
        );
    }

    @Test
    @DisplayName("로또 번호 중, 숫자가 아닌 문자가 있을 때")
    void isCorrectNumbers01() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> ErrorDetector.isCorrectNumbers("1,k,2,3,4,5")
        );
    }

    @Test
    @DisplayName("로또 번호 중, 길이가 6이 아닐 때")
    void isCorrectNumbers02() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> ErrorDetector.isCorrectNumbers("1,6,2,3,4,5,7")
        );
    }

    @Test
    @DisplayName("로또 번호 중, 범위를 초과했을 때")
    void isCorrectNumbers03() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> ErrorDetector.isCorrectNumbers("1,6,2,49,5,7")
        );
    }

    @Test
    @DisplayName("숫자가 아닌 경우")
    void isCorrectNumber01() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> ErrorDetector.isCorrectAmount("ㅋ")
        );
    }

    @Test
    @DisplayName("범위가 벗어난 경우")
    void isCorrectNumber02() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> ErrorDetector.isCorrectAmount("66")
        );
    }
}