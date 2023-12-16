package oncall.view

import camp.nextstep.edu.missionutils.Console
import oncall.model.Month
import oncall.model.TargetDate
import oncall.model.Weekday

class InputView {
    fun readTargetDate(): TargetDate {
        print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ")
        val line = Console.readLine()
        val splittedLine = line.split(",")
        require(splittedLine.size == 2)
        val monthInput = splittedLine[0].toIntOrNull() ?: throw IllegalArgumentException()
        val weekdayInput = splittedLine[1].trim()
        val month = Month(number = monthInput)
        val weekday = Weekday.createOrThrow(weekdayInput)
        return TargetDate(month = month, weekday = weekday)
    }
}