package pl.mkrowicki.fields

interface PrintField {

    fun print()

    fun PrintField.print(name: String, values: List<Int>) {
        name.print(values.joinToString(" "))
    }

    fun PrintField.print(name: String, value: String) {
        name.print(value)
    }

    private fun String.print(value: String) {
        println("%-14s%s".format(this, value))
    }
}
