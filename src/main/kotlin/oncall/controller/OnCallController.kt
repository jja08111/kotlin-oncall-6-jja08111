package oncall.controller

import oncall.model.Date
import oncall.model.WorkingGroup
import oncall.model.WorkingGroupTeam
import oncall.view.InputView
import oncall.view.OutputView

class OnCallController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView()
) {
    private fun inputTargetDate(): Date = inputUntilValid(
        onInvalid = outputView::printInvalidInputError
    ) {
        return readTargetDate()
    }

    private fun inputWorkingGroupTeam(): WorkingGroupTeam = inputUntilValid(
        onInvalid = outputView::printInvalidInputError
    ) {
        val weekdayNames = readWeekdayWorkingPeopleNames()
        val weekdayWorkingGroup = WorkingGroup(people = weekdayNames)
        val restDayNames = readRestDayWorkingPeopleNames()
        val restDayWorkingGroup = WorkingGroup(people = restDayNames)
        return WorkingGroupTeam(
            weekdayGroup = weekdayWorkingGroup,
            restDayGroup = restDayWorkingGroup
        )
    }

    private inline fun <T> inputUntilValid(onInvalid: () -> Unit, block: InputView.() -> T): T {
        while (true) {
            try {
                return inputView.block()
            } catch (e: IllegalArgumentException) {
                onInvalid()
            }
        }
    }

    fun run() {
        val targetDate = inputTargetDate()
        val team = inputWorkingGroupTeam()
        val sheet = team.createSheet(targetDate)
        outputView.printWorkingSheet(sheet, targetDate)
    }
}