package pl.mkrowicki.fields

data class Minute(val input: String) : CronField {
    val values = generate(input)

    override fun CronField.range() = Range(0, 59)

    override fun print() {
        print("minutes", values)
    }
}
