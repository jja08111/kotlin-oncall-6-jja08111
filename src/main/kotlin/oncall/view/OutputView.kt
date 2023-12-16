package oncall.view

import oncall.model.Person
import oncall.model.TargetDate
import oncall.model.Weekday
import oncall.util.isHoliday

class OutputView {
    fun printWorkingSheet(sheet: List<Person>, targetDate: TargetDate) {
        val month = targetDate.month
        var weekday = targetDate.weekday
        var day = 1
        sheet.forEach { person ->
            val shouldContainRestDayLabel = weekday.isWeekday && isHoliday(month, day)
            val restDayLabel = if (shouldContainRestDayLabel) "(휴일)" else ""
            println("${month.number}월 ${day}일 ${weekday.koreanLabel}$restDayLabel ${person.name}")
            weekday = weekday.next()
            day++
        }
    }

    fun printInvalidInputError() {
        printError("유효하지 않은 입력 값입니다. 다시 입력해 주세요.")
    }

    private fun printError(message: String) {
        println("[ERROR] $message")
    }

    private val Weekday.koreanLabel: String
        get() = when (this) {
            Weekday.Sunday -> "일"
            Weekday.Monday -> "월"
            Weekday.Tuesday -> "화"
            Weekday.Wednesday -> "수"
            Weekday.Thursday -> "목"
            Weekday.Friday -> "금"
            Weekday.Saturday -> "토"
        }
}