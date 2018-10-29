import edu.jesse.adventofcode2017.Day3SpiralMemory
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day3SpiralMemoryTest {

    private val day3SpiralMemory = Day3SpiralMemory()

    companion object {
        @JvmStatic
        private fun spiralMemoryProvider(): Stream<TestData> = Stream.of(
            TestData("1", "0"),
            TestData("12", "3"),
            TestData("23", "2"),
            TestData("1024", "31"),
            TestData("277678", "475")
        )
    }

    @ParameterizedTest
    @MethodSource("spiralMemoryProvider")
    fun spiralMemoryTest(data: TestData) {
        // Execute & Verify
        assertThat(day3SpiralMemory.run(arrayOf(data.input))).isEqualTo(data.expectedValue)
    }

    data class TestData(
        val input: String,
        val expectedValue: String
    )
}