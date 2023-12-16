package oncall.model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WorkingGroupTest {
    @Test
    fun `중복되는 이름을 가진 경우 예외를 던짐`() {
        val people = listOf(
            Person("name"),
            Person("hello"),
            Person("name"),
            Person("1"),
            Person("2")
        )
        assertThrows<IllegalArgumentException> {
            WorkingGroup(people)
        }
    }

    @Test
    fun `5명 미만인 경우 예외를 던짐`() {
        val people = mutableListOf<Person>()
        repeat(4) { index ->
            people.add(Person(index.toString()))
        }
        assertThrows<IllegalArgumentException> {
            WorkingGroup(people)
        }
    }

    @Test
    fun `35명 초과인 경우 예외를 던짐`() {
        val people = mutableListOf<Person>()
        repeat(36) { index ->
            people.add(Person(index.toString()))
        }
        assertThrows<IllegalArgumentException> {
            WorkingGroup(people)
        }
    }
}