package binary_search
fun missingK(array: IntArray, k: Int): Int {

    var low = 0
    var high = array.lastIndex

    while (low <= high) {

        val mid =(low+high)/2

        val missing = array[mid] - (mid+1)

        if (missing < k) {
            low = mid +1
        } else {
            high = mid -1
        }

    }

    return high + 1 + k

}


fun main() {
    val array = intArrayOf(2,3,4,7,11)

    println(missingK(array, 6))
}