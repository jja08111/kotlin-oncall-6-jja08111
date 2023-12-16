package oncall.model

import oncall.util.isHoliday

data class Date(val month: Month, val day: Int = 1, val weekday: Weekday) {
    init {
        require(day in 1..month.daySize)
    }

    val isRestDay: Boolean
        get() = weekday.isWeekend || isHoliday(month, day)

    fun next(): Date {
        val nextWeekDay = weekday.next()
        if (month.daySize == day) {
            return Date(month = month.next(), day = 1, weekday = nextWeekDay)
        }
        return Date(month = month, day = day + 1, weekday = nextWeekDay)
    }
}