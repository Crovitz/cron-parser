package pl.mkrowicki.fields

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.function.Executable
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.lang.System.setOut

class FieldsTest {
    private val standardOut = System.out
    private val outputStreamCaptor = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        setOut(PrintStream(outputStreamCaptor))
    }

    @AfterEach
    fun tearDown() {
        setOut(standardOut)
    }

    @Test
    fun `should create valid fields`() {
        // given
        val input = "*/15 0 1,15 * 1-5 /usr/bin/find"

        // when
        val result = Fields(input)

        // then
        assertAll(
            "fields",
            Executable { assertEquals("*/15", result.minutes.input) },
            Executable { assertEquals("0", result.hours.input) },
            Executable { assertEquals("1,15", result.daysOfMonth.input) },
            Executable { assertEquals("*", result.months.input) },
            Executable { assertEquals("1-5", result.daysOfWeek.input) },
            Executable { assertEquals("/usr/bin/find", result.command.input) },
        )
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "*/15 0 1,15 * 1-5 additional /usr/bin/find",
            "*/15 0 1,15 * 1-5",
        ],
    )
    fun `should throw exception when invalid input fields`(invalidInput: String) {
        // when & then
        val exception = assertThrows<IllegalArgumentException> {
            Fields(invalidInput)
        }
        assertTrue { exception.message?.contains("Invalid cron expression") ?: false }
    }

    @Test
    fun `should print fields table`() {
        // given
        val fields = Fields("*/15 0 1,15 * 1-5 /usr/bin/find")
        val expected = """
            minutes       0 15 30 45
            hour          0
            day of month  1 15
            month         1 2 3 4 5 6 7 8 9 10 11 12
            day of week   1 2 3 4 5
            command       /usr/bin/find
        """.trimIndent()

        // when
        fields.print()

        // then
        assertEquals(expected, outputStreamCaptor.toString().trim())
    }
}
