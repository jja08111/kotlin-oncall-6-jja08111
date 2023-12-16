package oncall.model

class WorkingGroup(
    private val people: List<Name>
) {
    init {
        require(people.size in WORKING_PEOPLE_RANGE)
        requireUnique(people)
    }

    private fun requireUnique(people: List<Name>) {
        val uniquePeople = people.toSet()
        require(uniquePeople.size == people.size)
    }

    companion object {
        private val WORKING_PEOPLE_RANGE = 5..35
    }
}