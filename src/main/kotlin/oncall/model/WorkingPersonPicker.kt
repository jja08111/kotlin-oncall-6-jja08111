package oncall.model

import java.util.ArrayDeque
import java.util.Queue

class WorkingPersonPicker(
    private val workingGroup: WorkingGroup,
) {
    private val waitingPeople: Queue<Person> = ArrayDeque()
    private var index = 0

    private fun moveIndexToNext() {
        index++
        if (index >= workingGroup.size) {
            index = 0
        }
    }

    fun pick(lastPerson: Person? = null): Person {
        if (waitingPeople.isNotEmpty()) {
            return waitingPeople.poll()
        }
        val person = workingGroup[index]
        moveIndexToNext()
        if (lastPerson == person) {
            waitingPeople.add(person)
            val nextPerson = workingGroup[index]
            moveIndexToNext()
            return nextPerson
        }
        return person
    }
}