package oncall.model

class WorkingGroup(
    private val people: List<Name>
) {
    init {
        require(people.size in WORKING_PEOPLE_RANGE)
        requireUnique(people)
    }

    val size: Int
        get() = people.size

    private fun requireUnique(people: List<Name>) {
        val uniquePeople = people.toSet()
        require(uniquePeople.size == people.size)
    }

    fun containsAll(other: WorkingGroup): Boolean {
        return people.containsAll(other.people)
    }

    operator fun get(index: Int): Name {
        return people[index]
    }

    companion object {
        private val WORKING_PEOPLE_RANGE = 5..35
    }
}