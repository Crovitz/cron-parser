package pl.mkrowicki.parser

import pl.mkrowicki.fields.Range

data class RangeParser(
    private val input: String,
) {

    fun parse(): List<Int> {
        val subFields = input.split("-")
        val start = subFields[0].toInt()
        val end = subFields[1].toInt()
        return Range(start, end).allValues()
    }
}
