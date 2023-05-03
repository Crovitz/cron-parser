package pl.mkrowicki.fields

data class Fields(
    private val input: String,
) {
    private val parts: List<String> = input.split(" ")
        .also { it.validate() }
    val minutes = Minute(parts[0])
    val hours = Hour(parts[1])
    val daysOfMonth = DayOfMonth(parts[2])
    val months = Month(parts[3])
    val daysOfWeek = DayOfWeek(parts[4])
    val command = Command(parts[5])

    fun print() {
        listOf(
            minutes,
            hours,
            daysOfMonth,
            months,
            daysOfWeek,
            command,
        ).forEach { it.print() }
    }
}

private fun List<String>.validate() {
    if (size != 6) {
        throw IllegalArgumentException(
            "Invalid cron expression ($size instead of 6), " +
                "please provide fields: <minute> <hour> <day-of-month> <month> <day-of-week> <command>",
        )
    }
}
