package pl.mkrowicki.fields

data class Command(val input: String) : PrintField {

    override fun print() = print("command", input)
}
