import edu.jesse.adventofcode2017.Day1InverseCaptcha
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day1InverseCaptchaTest {
    private val day1InverseCaptcha = Day1InverseCaptcha()

    companion object {
        @JvmStatic
        private fun inverseCaptchaProvider(): Stream<TestData> = Stream.of(
            TestData("1122", "3"),
            TestData("1111", "4"),
            TestData("1234", "0"),
            TestData("91212129", "9")
        )
    }

    @ParameterizedTest
    @MethodSource("inverseCaptchaProvider")
    fun inverseCaptchaTest(data: TestData) {
        // Execute & Verify
        assertThat(day1InverseCaptcha.run(arrayOf(data.input))).isEqualTo(data.expectedValue)
    }

    data class TestData(
        val input: String,
        val expectedValue: String
    )
}