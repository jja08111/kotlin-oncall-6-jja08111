package oncall.model

class WorkingGroupTeam(
    private val weekdayGroup: WorkingGroup,
    private val restDayGroup: WorkingGroup
) {
    init {
        require(weekdayGroup.containsAll(restDayGroup))
        require(weekdayGroup.size == restDayGroup.size)
    }

    fun createSheet(startDate: Date): MonthlyWorkingSheet {
        return MonthlyWorkingSheet(
            weekdayGroup = weekdayGroup,
            restDayGroup = restDayGroup,
            date = startDate
        )
    }
}