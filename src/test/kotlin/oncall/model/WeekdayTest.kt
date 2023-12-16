package oncall.model

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class WeekdayTest {
    @ParameterizedTest
    @ValueSource(strings = ["웍", "황", "숙", "모"])
    fun `잘못된 한글 요일을 입력하면 예외를 던짐`(weekdayInput: String) {
        assertThrows<IllegalArgumentException> {
            Weekday.createOrThrow(weekdayInput)
        }
    }
}