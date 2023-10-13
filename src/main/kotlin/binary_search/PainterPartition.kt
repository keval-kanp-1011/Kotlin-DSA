package binary_search


fun countPainter(array: IntArray, page: Int): Int {

    var pages = 0
    var painter = 1

    for (i in array) {
        if (pages + i <= page) {
            pages += i
        } else {
            pages = i
            painter++
        }
    }

    return painter
}
fun findTime(array: IntArray, m: Int): Int {

    if (m > array.size) return -1

    var low = array.maxOrNull()
    println(low)

    var high = array.sum()
    println(high)


    while (low!! <= high) {

        val mid = (low+high)/2

        if (countPainter(array, mid) > m) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }

    return low

}

fun main() {

    val array = intArrayOf(12,34,67,90)

    println(findTime(array, 2))

}