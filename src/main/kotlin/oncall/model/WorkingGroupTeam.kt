package oncall.model

import oncall.util.isHoliday

class WorkingGroupTeam(
    private val weekdayGroup: WorkingGroup,
    private val restDayGroup: WorkingGroup
) {
    init {
        require(weekdayGroup.containsAll(restDayGroup))
        require(weekdayGroup.size == restDayGroup.size)
    }

    fun createSheet(targetDate: TargetDate): List<Person> {
        val weekdayWorkingPersonPicker = WorkingPersonPicker(weekdayGroup)
        val restDayWorkingPersonPicker = WorkingPersonPicker(restDayGroup)
        val month = targetDate.month
        var currentWeekday = targetDate.weekday
        var currentDay = 1
        val sheet = mutableListOf<Person>()
        while (sheet.size < month.daySize) {
            val isRestDay = currentWeekday.isWeekend || isHoliday(month, currentDay)
            currentWeekday = currentWeekday.next()
            currentDay++
            val lastPerson = sheet.lastOrNull()
            val person = if (isRestDay) {
                restDayWorkingPersonPicker.pick(lastPerson)
            } else {
                weekdayWorkingPersonPicker.pick(lastPerson)
            }
            sheet.add(person)
        }
        return sheet
    }
}