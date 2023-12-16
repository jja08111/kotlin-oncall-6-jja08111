package oncall.view

class OutputView {
    fun printTargetDateInputError() {
        printError("유효하지 않은 입력 값입니다. 다시 입력해 주세요.")
    }

    private fun printError(message: String) {
        println("[ERROR] $message")
    }
}