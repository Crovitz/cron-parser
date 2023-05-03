package pl.mkrowicki.fields

data class DayOfMonth(val input: String) : CronField {
    private val values = generate(input)

    override fun CronField.range() = Range(1, 31)

    override fun print() {
        print("day of month", values)
    }
}
