fun noOfDays(array: IntArray, minCap: Int): Int {
    var days = 1
    var weights = 0
    for (i in array) {
        if (weights + i > minCap) {
            days += 1
            weights = i
        } else {
            weights += i
        }
    }

    return days
}

fun findMinCapacityToLoad(array: IntArray, limit : Int): Int {
    var low = array.maxOrNull()!!
    var high = array.sum()

    while (low <= high) {

        val mid = (low+high)/2

        if (noOfDays(array, mid) <= limit) {

            high = mid - 1
        } else {
            low = mid + 1
        }
    }

    return low
}

fun main() {

    val array = intArrayOf(1,2,3,4,5,6,7,8,9,10)

    println(findMinCapacityToLoad(array, 5))
}