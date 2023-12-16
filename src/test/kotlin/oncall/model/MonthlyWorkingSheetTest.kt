package oncall.model

import oncall.model.mock.restDayGroup1
import oncall.model.mock.sheetResult1
import oncall.model.mock.targetDate1
import oncall.model.mock.weekdayGroup1
import org.junit.jupiter.api.Test

class MonthlyWorkingSheetTest {
    @Test
    fun `생성 테스트`() {
        val sheet = MonthlyWorkingSheet(
            weekdayGroup = weekdayGroup1,
            restDayGroup = restDayGroup1,
            date = targetDate1
        )

        assert(sheet.size == sheetResult1.size)
        sheet.forEachIndexed { index, person ->
            assert(person == sheetResult1[index])
        }
    }
}