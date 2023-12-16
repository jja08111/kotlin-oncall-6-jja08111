package oncall.model

@JvmInline
value class Month(val value: Int) {
    init {
        require(value in 1..12)
    }

    fun next(): Month {
        if (value == 12) {
            return Month(1)
        }
        return Month(value + 1)
    }

    val daySize: Int
        get() = when (value) {
            2 -> 28
            1, 3, 5, 7, 8, 10, 12 -> 31
            4, 6, 9, 11 -> 30
            else -> throw IllegalStateException()
        }
}