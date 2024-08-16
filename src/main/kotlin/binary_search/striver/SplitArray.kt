package binary_search.striver

fun countSubArrays(array: IntArray, page: Int): Int {

    var pages = 0
    var subArrays = 1

    for (i in array) {
        if (pages + i <= page) {
            pages += i
        } else {
            pages = i
            subArrays++
        }
    }

    return subArrays
}
fun findSum(array: IntArray, m: Int): Int {

    if (m > array.size) return -1

    var low = array.maxOrNull()
    println(low)

    var high = array.sum()
    println(high)


    while (low!! <= high) {

        val mid = (low+high)/2

        if (countSubArrays(array, mid) > m) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }

    return low

}

fun main() {

    val array = intArrayOf(12,34,67,90)

    println(findSum(array, 2))

}