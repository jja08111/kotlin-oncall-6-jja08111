package oncall.model

import org.junit.jupiter.api.Test

class WorkingPersonPickerTest {
    @Test
    fun `lastPerson과 동일한 Person이 반환될 차례에는 다음 인덱스 Person이 반환된다`() {
        val people = listOf(Person("1"), Person("2"), Person("3"), Person("4"), Person("5"))
        val workingGroup = WorkingGroup(people)
        val picker = WorkingPersonPicker(workingGroup)

        val pickedPerson = picker.pick(people[0])

        assert(pickedPerson == people[1])
    }

    @Test
    fun `pick을 하면 순차적으로 반환된다`() {
        val people = listOf(Person("1"), Person("2"), Person("3"), Person("4"), Person("5"))
        val workingGroup = WorkingGroup(people)
        val picker = WorkingPersonPicker(workingGroup)

        repeat(15) { index ->
            val pickedPerson = picker.pick()
            assert(pickedPerson == people[index % people.size])
        }
    }
}