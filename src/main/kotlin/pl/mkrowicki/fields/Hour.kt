package pl.mkrowicki.fields

data class Hour(val input: String) : CronField {
    private val values = generate(input)

    override fun CronField.range() = Range(0, 23)

    override fun print() {
        print("hour", values)
    }
}
