val A = longArrayOf(1, 0)
val B = longArrayOf(0, 1)
var M = arrayOf(A, B)
val I = arrayOf(B, longArrayOf(1, 1))
var fibons: MutableMap<Int, Long> = mutableMapOf()

fun calcFibonacciRecursive(n: Int, lastDigit: Boolean = false): Long {
    if (n <= 1) return n.toLong()
    return if (lastDigit) (calcFibonacciRecursive(n - 2) + calcFibonacciRecursive(n - 1)) % 10
    else calcFibonacciRecursive(n - 2) + calcFibonacciRecursive(n - 1)
}

fun calcLastDigitOfFibonacciRecursive(n: Int): Long {
    return  calcFibonacciRecursive(n) % 10
}

fun calFibonacciIterative(n: Int, lastDigit: Boolean = false): Long {
    if ( n <= 1) return n.toLong()

    var previous = 0L
    var current = 1L
    repeat(n-1) {
        var oldPrevious = previous
        previous = current
        current += if (lastDigit) oldPrevious % 10 else oldPrevious
    }

    return current
}

fun calLastDigitOfFibonacciIterative(n: Int): Long {
    return calFibonacciIterative(n, true) % 10
}

fun calFibonacciMemoization(n: Int, lastDigit: Boolean = false): Long {
    if (!fibons.contains(n)) {

        if ( n <= 1) {
            fibons[n] = n.toLong()
        } else {
            if (lastDigit) {
                fibons[n] = (calFibonacciMemoization(n - 2, lastDigit) + calFibonacciMemoization(n - 1, lastDigit)) % 10
            } else {
                fibons[n] = calFibonacciMemoization(n - 2) + calFibonacciMemoization(n - 1)
            }
        }
    }
    return fibons.get(n)!!
}

fun calLastDigitOfFibonacciMemoization(n: Int): Long {
    return calFibonacciMemoization(n, true) % 10
}

fun calFibonacciMatrixExp(n: Int, lastDigit: Boolean = false): Long {
    val P = calcMatrixExp(n, I, lastDigit)
    println(P[0][0])
    println(P[0][1])
    println(P[1][0])
    println(P[1][1])
    return P[1][0]
}

private fun calcMatrixExp(n: Int, m: Array<LongArray>, lastDigit: Boolean): Array<LongArray> {
    if (n == 0) return M
    else if ( n % 2 == 0 ) {
        val Z = calcMatrixExp(n / 2, m, lastDigit)
        return if (lastDigit) timesMatricesMod10(Z, Z) else timesMatrices(Z, Z)
    } else {
        val Z = calcMatrixExp(n / 2, m, lastDigit)
        val W = timesMatrices(Z, Z)
        return if (lastDigit) timesMatricesMod10(W, m) else timesMatrices(W, m)
    }
}

private fun timesMatrices(a: Array<LongArray>, b: Array<LongArray>): Array<LongArray> {
    var c = arrayOf(longArrayOf(0, 0), longArrayOf(0, 0))
    c[0][0] = a[0][0] * b[0][0] + a[0][1] * b[1][0]
    c[0][1] = a[0][0] * b[0][1] + a[0][1] * b[1][1]
    c[1][0] = a[1][0] * b[0][0] + a[1][1] * b[1][0]
    c[1][1] = a[1][0] * b[0][1] + a[1][1] * b[1][1]
    return c
}

private fun timesMatricesMod10(a: Array<LongArray>, b: Array<LongArray>): Array<LongArray> {
    var c = arrayOf(longArrayOf(0, 0), longArrayOf(0, 0))
    c[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % 10
    c[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % 10
    c[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % 10
    c[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % 10
    return c
}

fun calLastDigitOfFibonacciMatrixExp(n: Int): Long {
    return calFibonacciMatrixExp(n, true) % 10
}