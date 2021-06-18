import kotlin.test.Test
import kotlin.test.assertEquals

class FibonacciMemoizationTest {

    @Test
    fun test0() {
        val response = calFibonacciMemoization(3)
        val expected = 2
        assertEquals(expected, response)
    }

    @Test
    fun test1() {
        val response = calFibonacciMemoization(10)
        val expected = 55
        assertEquals(expected, response)
    }

    @Test
    fun test2() {
        val response = calFibonacciMemoization(75)
        val expected = 2111485077978050L
        assertEquals(expected, response.toLong())
    }

    @Test
    fun test3() {
        val response = calFibonacciMemoization(157)
        val expected = "289450641941273985495088042104137"
        assertEquals(expected, response.toString())
    }

}