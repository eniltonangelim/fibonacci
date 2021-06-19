
import org.junit.jupiter.api.assertTimeoutPreemptively
import java.time.Duration
import kotlin.test.assertEquals
import kotlin.test.Test

class FibonacciMatrixExpTest {

    @Test
    fun test0() {
        val response = calFibonacciMatrixExp(3)
        val expected = 2L
        assertEquals(expected, response)
    }

    @Test
    fun test1() {
        val response = calFibonacciMatrixExp(10)
        val expected = 55L
        assertEquals(expected, response)
    }

    @Test
    fun test2() {
        assertTimeoutPreemptively(Duration.ofMillis(13)) {
            val response = calFibonacciMatrixExp(75)
            val expected = 2111485077978050
            assertEquals(expected, response)
        }
    }

    @Test
    fun test3() {
        assertTimeoutPreemptively(Duration.ofMillis(30)) {
            val response = calFibonacciMatrixExp(157)
            val expected = "289450641941273985495088042104137"
            assertEquals(expected, response.toString())
        }
    }

    @Test
    fun test4() {
        assertTimeoutPreemptively(Duration.ofMillis(25)) {
            val response = calLastDigitOfFibonacciMatrixExp(157)
            val expected = 7L
            assertEquals(expected, response)
        }
    }

}