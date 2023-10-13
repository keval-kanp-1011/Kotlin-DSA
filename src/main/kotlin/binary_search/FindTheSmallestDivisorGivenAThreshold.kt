package binary_search

import kotlin.math.ceil

fun sumOfD(array: IntArray, div: Int): Int {

    var sum = 0

    for (i in array) {
        sum += ceil(i.toDouble() / div.toDouble()).toInt()
    }

    return sum

}
fun smallestDivisor(array: IntArray, limit: Int): Int {

    var low = 1
    var high = array.maxOrNull()!!

    if (array.size > limit) return -1

    while (low <= high) {

        val mid = (low+high)/2

        if (sumOfD(array, mid) <= limit) {
            high = mid -1
        } else {
            low = mid + 1
        }
    }

    return low

}

fun main() {

    val array = intArrayOf(1,2,3,4,5)
    println(smallestDivisor(array, 8))

}