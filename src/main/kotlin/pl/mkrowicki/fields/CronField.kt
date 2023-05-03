package pl.mkrowicki.fields

import pl.mkrowicki.parser.Parser

interface CronField : PrintField {

    fun CronField.range(): Range

    fun CronField.generate(value: String): List<Int> {
        return when (value) {
            "*" -> range().allValues()
            else -> value.parse()
        }
    }

    private fun String.parse(): List<Int> {
        return split(",")
            .flatMap { Parser(it, range()).parse() }
    }
}
