package oncall.util

import oncall.model.Month

private data class Date(val month: Month, val day: Int)

private val holidays = listOf(
    Date(month = Month(1), day = 1),
    Date(month = Month(3), day = 1),
    Date(month = Month(5), day = 5),
    Date(month = Month(6), day = 6),
    Date(month = Month(8), day = 15),
    Date(month = Month(10), day = 3),
    Date(month = Month(10), day = 9),
    Date(month = Month(12), day = 25)
)

fun isHoliday(month: Month, day: Int): Boolean {
    return holidays.any { it.month == month && it.day == day }
}