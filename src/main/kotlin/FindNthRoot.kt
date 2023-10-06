

fun findNthRoot(number: Int, n: Int): Int {

    var low = 1
    var high = number

    while (low <= high) {

        val mid = (low+high)/2

        if (func(number, n, mid) == 1) return mid

        if (func(number, n, mid) == 0) {
            low = mid+1
        } else {
            high = mid-1
        }
    }

    return -1

}

fun func(m: Int, n: Int, mid: Int): Int {
    var nthsquare = 1
    for (i in 1..n)  {
        nthsquare *= mid
        if (nthsquare > m) return 2
    }
    if (nthsquare == m) return 1
    return 0
}

fun main() {

    println(findNthRoot(27, 3))
}