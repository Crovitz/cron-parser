package pl.mkrowicki.fields

data class Range(
    val min: Int,
    val max: Int,
) {
    fun allValues(): List<Int> = (min..max).toList()
}
