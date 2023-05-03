package pl.mkrowicki.fields

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class MinuteTest {

    @Test
    fun `should generate a list with a single value when input is a digit`() {
        // when
        val minute = Minute("5")

        // then
        assertEquals(listOf(5), minute.values)
    }

    @Test
    fun `should generate a list with a single value when input is asterisk`() {
        // when
        val minute = Minute("*")

        // then
        assertEquals((0..59).toList(), minute.values)
    }

    @Test
    fun `should generate a list of values when input is a list of digits`() {
        // when
        val minute = Minute("1,15,30")

        // then
        assertEquals(listOf(1, 15, 30), minute.values)
    }

    @Test
    fun `should generate a list of values when input is a range of digits`() {
        // when
        val minute = Minute("5-10")

        // then
        assertEquals(listOf(5, 6, 7, 8, 9, 10), minute.values)
    }

    @Test
    fun `should generate a list of values when input is a range and a list of digits`() {
        // when
        val minute = Minute("1,5-10,30")

        // then
        assertEquals(listOf(1, 5, 6, 7, 8, 9, 10, 30), minute.values)
    }

    @Test
    fun `should throw an exception when input is invalid`() {
        // when
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Minute("abc")
        }

        // then
        assertEquals("Invalid input: expected integer, got Parser(input=abc, range=Range(min=0, max=59))", exception.message)
    }
}
