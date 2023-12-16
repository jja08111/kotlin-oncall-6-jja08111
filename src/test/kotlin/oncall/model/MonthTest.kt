package oncall.model

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class MonthTest {
    @ParameterizedTest
    @ValueSource(ints = [-21, 0, 13, 3215])
    fun `잘못된 월 숫자를 입력하면 예외를 던짐`(monthNumber: Int) {
        assertThrows<IllegalArgumentException> {
            Month(monthNumber)
        }
    }
}