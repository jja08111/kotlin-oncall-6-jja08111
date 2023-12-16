package oncall.model

class WorkingGroupTeam(
    private val weekdayGroup: WorkingGroup,
    private val restDayGroup: WorkingGroup
) {
    init {
        require(weekdayGroup.containsAll(restDayGroup))
        require(weekdayGroup.size == restDayGroup.size)
    }

    fun createSheet(startDate: Date): List<Person> {
        require(startDate.day == 1)
        val weekdayWorkingPersonPicker = WorkingPersonPicker(weekdayGroup)
        val restDayWorkingPersonPicker = WorkingPersonPicker(restDayGroup)
        val month = startDate.month
        var currentDate = startDate
        val sheet = mutableListOf<Person>()
        while (sheet.size < month.daySize) {
            val lastPerson = sheet.lastOrNull()
            val person = if (currentDate.isRestDay) {
                restDayWorkingPersonPicker.pick(lastPerson)
            } else {
                weekdayWorkingPersonPicker.pick(lastPerson)
            }
            sheet.add(person)
            currentDate = currentDate.next()
        }
        return sheet
    }
}