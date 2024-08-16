package binary_search.striver
fun possible(array: IntArray, day: Int, m: Int, k: Int) : Boolean {

    var count = 0
    var noOfB = 0

    for (i in array) {
        if (i <= day) {
            count++

        } else {
            noOfB += count / (m * k)
            count = 0

        }

        noOfB += count / (m * k)
    }

    return noOfB >= m

}


/**
 *Binary Search
 */
fun roseGarden(array: IntArray, m: Int, k: Int): Int {

    var low = array.minOrNull()
    var high = array.maxOrNull()

    println(low)
    println(high)

    if (m*k > array.size) return -1

    while (low!! <= high!!) {

        val mid = (low+high)/2

        if (possible(array, mid, m, k)) {
            high = mid - 1
        } else {
            low = mid + 1
        }
    }

    return low
}

fun main() {

    val arr = intArrayOf(7, 7, 7, 7, 13, 11, 12, 7)
    val k = 3
    val m = 2
    val ans = roseGarden(arr, k, m)

    println(ans)
}