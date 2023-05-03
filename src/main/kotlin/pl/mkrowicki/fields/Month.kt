package pl.mkrowicki.fields

data class Month(val input: String) : CronField {
    private val values = generate(input)

    override fun CronField.range() = Range(1, 12)

    override fun print() {
        print("month", values)
    }
}
