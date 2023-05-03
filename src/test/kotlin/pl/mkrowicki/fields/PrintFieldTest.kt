package pl.mkrowicki.fields

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class PrintFieldTest {

    private val testedPrintField = object : PrintField {
        override fun print() {}

        fun printList(name: String, values: List<Int>): String {
            val baos = ByteArrayOutputStream()
            System.setOut(PrintStream(baos))
            print(name, values)
            return baos.toString().trim()
        }

        fun printValue(name: String, value: String): String {
            val baos = ByteArrayOutputStream()
            System.setOut(PrintStream(baos))
            print(name, value)
            return baos.toString().trim()
        }
    }

    @Test
    fun `should print a list of values with the given name`() {
        val values = listOf(1, 2, 3)
        val output = testedPrintField.printList("Test Name", values)
        assertEquals("Test Name     1 2 3", output)
    }

    @Test
    fun `should print a single value with the given name`() {
        val output = testedPrintField.printValue("Test Name", "123")
        assertEquals("Test Name     123", output)
    }
}
