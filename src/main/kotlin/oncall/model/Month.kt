package oncall.model

@JvmInline
value class Month(val number: Int) {
    init {
        require(number in 1..12)
    }
}