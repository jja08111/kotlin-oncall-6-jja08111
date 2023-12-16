package oncall.model

@JvmInline
value class Name(val name: String) {
    init {
        require(name.length <= NAME_MAX_LENGTH)
    }

    companion object {
        private const val NAME_MAX_LENGTH = 5
    }
}