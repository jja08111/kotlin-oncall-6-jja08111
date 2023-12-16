package oncall.model

class MonthlyWorkingSheet(
    weekdayGroup: WorkingGroup,
    restDayGroup: WorkingGroup,
    val date: Date
) : Iterable<Person> {

    private val workingOrder: List<Person>

    val size: Int
        get() = workingOrder.size

    init {
        require(date.day == 1)
        val weekdayWorkingPersonPicker = WorkingPersonPicker(weekdayGroup)
        val restDayWorkingPersonPicker = WorkingPersonPicker(restDayGroup)
        val month = date.month
        var currentDate = date
        val workingOrder = mutableListOf<Person>()
        while (workingOrder.size < month.daySize) {
            val lastPerson = workingOrder.lastOrNull()
            val person = if (currentDate.isRestDay) {
                restDayWorkingPersonPicker.pick(lastPerson)
            } else {
                weekdayWorkingPersonPicker.pick(lastPerson)
            }
            workingOrder.add(person)
            currentDate = currentDate.next()
        }
        this.workingOrder = workingOrder
    }

    override fun iterator(): Iterator<Person> {
        return workingOrder.iterator()
    }
}