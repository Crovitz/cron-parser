package pl.mkrowicki

import pl.mkrowicki.fields.Fields

fun main(args: Array<String>) {
    val fields = Fields(args[0])

    fields.print()
}
