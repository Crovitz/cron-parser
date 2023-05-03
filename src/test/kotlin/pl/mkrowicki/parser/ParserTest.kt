package pl.mkrowicki.parser

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import pl.mkrowicki.fields.Range

class ParserTest {

    @Test
    fun `should return a list with a single integer when input is a digit`() {
        // given
        val parser = Parser("123", Range(0, 2))

        // when
        val result = parser.parse()

        // then
        assertEquals(listOf(123), result)
    }

    @Test
    fun `should return a list of integers when input is a range`() {
        // given
        val parser = Parser("1-5", Range(0, 3))

        // when
        val result = parser.parse()

        // then
        assertEquals(listOf(1, 2, 3, 4, 5), result)
    }

    @Test
    fun `should return a list of integers when input is a range and range indices are out of bounds`() {
        // given
        val parser = Parser("2-5", Range(0, 7))

        // when
        val result = parser.parse()

        // then
        assertEquals(listOf(2, 3, 4, 5), result)
    }

    @Test
    fun `should return a list of integers when input is an internal representation`() {
        // given
        val parser = Parser("1/2", Range(0, 5))

        // when
        val result = parser.parse()

        // then
        assertEquals(listOf(1, 3, 5), result)
    }

    @Test
    fun `should throw an exception when input is invalid`() {
        // given
        val parser = Parser("abc", Range(0, 2))

        // when & then
        assertThrows(IllegalArgumentException::class.java) {
            parser.parse()
        }
    }
}
