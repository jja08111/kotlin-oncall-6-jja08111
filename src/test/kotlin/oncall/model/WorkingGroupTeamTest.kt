package oncall.model

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
}