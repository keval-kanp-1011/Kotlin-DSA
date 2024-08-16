package binary_search.striver

fun canWePlace(array: IntArray, dist: Int, cows: Int): Boolean {

    var calculatedCows = 1
    var lastCow = array[0]

    for (i in array) {

        if (i - lastCow >= dist) {

            calculatedCows++
            lastCow = i
        }
    }

    return calculatedCows >= cows

}

fun minDist(array: IntArray, cows: Int): Int {

    var low = 1
    var high = array.maxOrNull()!! - array.minOrNull()!!

    while (low <= high) {

        val mid = (low+high)/2

        if (canWePlace(array, mid, cows)) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }

    return high
}

fun main() {

    val array = intArrayOf(1,2,3)
    println(minDist(array, 2))

}