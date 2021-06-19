import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertTimeoutPreemptively
import java.time.Duration
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class FibonacciMemoizationTest {

    @BeforeTest
    fun before() {
        fibons = mutableMapOf()
    }

    @Test
    fun test0() {
        val response = calFibonacciMemoization(3)
        val expected = 2L
        assertEquals(expected, response)
    }

    @Test
    fun test1() {
        val response = calFibonacciMemoization(10)
        val expected = 55L
        assertEquals(expected, response)
    }

    @Test
    fun test2() {
        assertTimeoutPreemptively(Duration.ofMillis(13)) {
            val response = calFibonacciMemoization(75)
            val expected = 2111485077978050L
            assertEquals(expected, response)
        }
    }

    @Test
    fun test3() {
        val response = calFibonacciMemoization(157)
        val expected = "289450641941273985495088042104137"
        assertEquals(expected, response.toString())
    }

    @Test
    fun test4() {
        assertTimeoutPreemptively(Duration.ofMillis(50)) {
            val response = calLastDigitOfFibonacciMemoization(157)
            val expected = 7L
            assertEquals(expected, response)
        }
    }

}