package oncall.model

import oncall.util.isHoliday
import java.util.Queue
import java.util.ArrayDeque

class WorkingGroupTeam(
    private val weekdayGroup: WorkingGroup,
    private val restDayGroup: WorkingGroup
) {
    init {
        require(weekdayGroup.containsAll(restDayGroup))
        require(weekdayGroup.size == restDayGroup.size)
    }

    fun createSheet(targetDate: TargetDate): List<Name> {
        val month = targetDate.month
        val daySize = month.daySize
        val weekDayQueue: Queue<Name> = ArrayDeque()
        val restDayQueue: Queue<Name> = ArrayDeque()
        var currentWeekday = targetDate.weekday
        var currentDay = 1
        var weekdayGroupIndex = 0
        var restDayGroupIndex = 0
        val sheet = mutableListOf<Name>()
        val moveNextRestDayGroupIndex = {
            restDayGroupIndex++
            if (restDayGroupIndex >= restDayGroup.size) {
                restDayGroupIndex = 0
            }
        }
        val moveNextWeekdayGroupIndex = {
            weekdayGroupIndex++
            if (weekdayGroupIndex >= weekdayGroup.size) {
                weekdayGroupIndex = 0
            }
        }
        while (sheet.size < daySize) {
            if (weekdayGroupIndex >= weekdayGroup.size) {
                weekdayGroupIndex = 0
            }
            val isRestDay = currentWeekday.isWeekend || isHoliday(month, currentDay)

            currentWeekday = currentWeekday.next()
            currentDay++

            if (isRestDay) {
                if (restDayQueue.isNotEmpty()) {
                    val person = restDayQueue.poll()
                    sheet.add(person)
                    continue
                }
                val person: Name = restDayGroup[restDayGroupIndex]
                moveNextRestDayGroupIndex()
                val lastPerson: Name? = sheet.lastOrNull()
                if (lastPerson == person) {
                    restDayQueue.add(person)
                    val nextPerson: Name = restDayGroup[restDayGroupIndex]
                    moveNextRestDayGroupIndex()
                    sheet.add(nextPerson)
                    continue
                }
                sheet.add(person)
                continue
            }

            if (weekDayQueue.isNotEmpty()) {
                val person = weekDayQueue.poll()
                sheet.add(person)
                continue
            }
            val person: Name = weekdayGroup[weekdayGroupIndex]
            moveNextWeekdayGroupIndex()
            val lastPerson: Name? = sheet.lastOrNull()
            if (lastPerson == person) {
                weekDayQueue.add(person)
                val nextPerson: Name = weekdayGroup[weekdayGroupIndex]
                moveNextWeekdayGroupIndex()
                sheet.add(nextPerson)
                continue
            }
            sheet.add(person)
        }
        return sheet
    }
}