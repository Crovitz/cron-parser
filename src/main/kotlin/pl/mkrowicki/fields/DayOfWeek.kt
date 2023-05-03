package pl.mkrowicki.fields

data class DayOfWeek(val input: String) : CronField {
    private val values = generate(input)

    override fun CronField.range() = Range(1, 7)

    override fun print() {
        print("day of week", values)
    }
}
