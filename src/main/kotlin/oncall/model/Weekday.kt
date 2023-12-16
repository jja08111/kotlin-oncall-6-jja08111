package oncall.model

enum class Weekday {
    Sunday,
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday;

    val isWeekend: Boolean
        get() = when (this) {
            Sunday, Saturday -> true
            else -> false
        }

    val isWeekday: Boolean
        get() = !isWeekend

    fun next(): Weekday {
        return when (this) {
            Sunday -> Monday
            Monday -> Tuesday
            Tuesday -> Wednesday
            Wednesday -> Thursday
            Thursday -> Friday
            Friday -> Saturday
            Saturday -> Sunday
        }
    }

    companion object {
        fun createOrThrow(koreanWeekdayName: String): Weekday {
            return when (koreanWeekdayName) {
                "일" -> Sunday
                "월" -> Monday
                "화" -> Tuesday
                "수" -> Wednesday
                "목" -> Thursday
                "금" -> Friday
                "토" -> Saturday
                else -> throw IllegalArgumentException()
            }
        }
    }
}
