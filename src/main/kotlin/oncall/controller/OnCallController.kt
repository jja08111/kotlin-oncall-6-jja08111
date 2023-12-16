package oncall.controller

import oncall.model.TargetDate
import oncall.model.WorkingGroup
import oncall.view.InputView
import oncall.view.OutputView

class OnCallController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView()
) {
    private fun inputTargetDate(): TargetDate = inputUntilValid(
        onInvalid = outputView::printInvalidInputError
    ) {
        return readTargetDate()
    }

    private fun inputWeekdayWorkingGroup(): WorkingGroup = inputUntilValid(
        onInvalid = outputView::printInvalidInputError
    ) {
        val names = readWeekdayWorkingPeopleNames()
        return WorkingGroup(people = names)
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
        val weekdayWorkingGroup = inputWeekdayWorkingGroup()
        println(weekdayWorkingGroup)
    }
}