package pl.mkrowicki.parser

import pl.mkrowicki.fields.Range

data class Parser(
    val input: String,
    val range: Range,
) {

    fun parse(): List<Int> {
        return try {
            when {
                isInternal() -> InternalParser(input, range).parse()
                isRange() -> RangeParser(input).parse()
                else -> getDigit()
            }
        } catch (ex: Exception) {
            throw IllegalArgumentException("Invalid input: expected integer, got $this", ex)
        }
    }

    private fun isInternal() = input.contains("/")

    private fun isRange() = input.contains("-")

    private fun getDigit() = listOf(input.toInt())
}
