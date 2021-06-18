import kotlin.test.Test
import kotlin.test.assertEquals

class FibonacciIterativeTest {

    @Test
    fun test0() {
        val response = calFibonacciIterative(3)
        val expected = 2
        assertEquals(expected, response)
    }

    @Test
    fun test1() {
        val response = calFibonacciIterative(10)
        val expected = 55
        assertEquals(expected, response)
    }

    @Test
    fun test2() {
        val response = calFibonacciIterative(75)
        val expected = 2111485077978050L
        assertEquals(expected, response.toLong())
    }

    @Test
    fun test3() {
        val response = calFibonacciIterative(157)
        val expected = "289450641941273985495088042104137"
        assertEquals(expected, response.toString())
    }

}