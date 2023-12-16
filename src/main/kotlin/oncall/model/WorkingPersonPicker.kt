package oncall.model

import java.util.ArrayDeque
import java.util.Queue

class WorkingPersonPicker(
    private val workingGroup: WorkingGroup,
) {
    private val waitingPeople: Queue<Person> = ArrayDeque()
    private var index = 0

    private fun next(): Person {
        val person = workingGroup[index]
        index++
        if (index >= workingGroup.size) {
            index = 0
        }
        return person
    }

    fun pick(lastPerson: Person? = null): Person {
        if (waitingPeople.isNotEmpty()) {
            return waitingPeople.poll()
        }
        val person = next()
        if (lastPerson == person) {
            waitingPeople.add(person)
            return next()
        }
        return person
    }
}