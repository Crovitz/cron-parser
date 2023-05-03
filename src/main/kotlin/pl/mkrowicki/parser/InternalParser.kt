package pl.mkrowicki.parser

import pl.mkrowicki.fields.Range

data class InternalParser(
    private val input: String,
    private val range: Range,
) {

    fun parse(): List<Int> {
        val subFields = input.split("/")
        val start = if (subFields[0] == "*") 0 else subFields[0].toInt()
        val interval = subFields[1].toInt()
        return (start..range.max step interval).toList()
    }
}
