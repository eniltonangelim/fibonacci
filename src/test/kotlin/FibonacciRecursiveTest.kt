import org.junit.jupiter.api.assertTimeoutPreemptively
import java.time.Duration
import kotlin.test.Test
import kotlin.test.assertEquals

class FibonacciRecursiveTest {

    @Test
    fun test0() {
        val response = calcFibonacciRecursive(3)
        val expected = 2L
        assertEquals(expected, response)
    }

    @Test
    fun test1() {
        val response = calcFibonacciRecursive(10)
        val expected = 55L
        assertEquals(expected, response)
    }

    @Test
    fun test2() {
        assertTimeoutPreemptively(Duration.ofMillis(13)) {
            val response = calcFibonacciRecursive(75)
            val expected = 2111485077978050
            assertEquals(expected, response)
        }
    }

    @Test
    fun test3() {
        assertTimeoutPreemptively(Duration.ofMillis(30)) {
            val response = calcFibonacciRecursive(157)
            val expected = "289450641941273985495088042104137"
            assertEquals(expected, response.toString())
        }
    }

    @Test
    fun test4() {
        assertTimeoutPreemptively(Duration.ofMillis(640000)) {
            val response = calcLastDigitOfFibonacciRecursive(157)
            val expected = 7L
            assertEquals(expected, response)
        }
    }

}