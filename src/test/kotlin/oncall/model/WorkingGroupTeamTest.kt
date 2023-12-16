package oncall.model

import oncall.model.mock.restDay1
import oncall.model.mock.sheetResult1
import oncall.model.mock.targetDate1
import oncall.model.mock.weekday1
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WorkingGroupTeamTest {
    @Test
    fun `근무 인원이 다른 경우 예외를 던짐`() {
        val groupA = WorkingGroup(listOf(Name("1"), Name("2"), Name("3"), Name("4"), Name("5")))
        val groupB = WorkingGroup(listOf(Name("1"), Name("6"), Name("3"), Name("4"), Name("5")))
        assertThrows<IllegalArgumentException> {
            WorkingGroupTeam(groupA, groupB)
        }
    }

    @Test
    fun `근무 인원 숫자가 다른 경우 예외를 던짐`() {
        val groupA = WorkingGroup(
            listOf(Name("1"), Name("2"), Name("3"), Name("4"), Name("5"), Name("6"))
        )
        val groupB = WorkingGroup(
            listOf(Name("1"), Name("2"), Name("3"), Name("4"), Name("5"))
        )
        assertThrows<IllegalArgumentException> {
            WorkingGroupTeam(groupA, groupB)
        }
    }

    @Test
    fun `근무표 생성 테스트`() {
        val team = WorkingGroupTeam(weekday1, restDay1)

        val sheet = team.createSheet(targetDate1)

        assert(sheet.size == sheetResult1.size)
        sheet.forEachIndexed { index, person ->
            assert(person == sheetResult1[index])
        }
    }
}