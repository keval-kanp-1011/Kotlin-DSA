package binary_search
/**
 *BruteForce Approach
 */
fun findAPickElement(array: IntArray) : Int {


    //for only one peak
    for (i in array.indices) {

        if ((i == 0 || array[i-1] < array[i]) && (i == array.lastIndex || array[i] > array[i+1])) {
            return i
        }
    }


    return -1
}

/**
 * Optimized Approach Using Binary Search
 */
fun findAPickElementOptimized(array: IntArray): Int {


    //if multiple peak is available return any one of the peak.
    if (array.size == 1) return 0

    if (array[0] > array[1]) return 0

    if (array[array.lastIndex] > array[array.lastIndex - 1]) return  array.lastIndex

    var low = 0
    var high = array.lastIndex - 2

    while (low <= high) {
        val mid = (low+high)/2


        if ( array[mid] > array[mid-1] && array[mid] > array[mid+1]) {
            return mid
        } else if (array[mid] > array[mid - 1]) {
            low = mid+1
        } else {
            //two cases are considered
            //1. mid is on the Right Arm
            //2. array[mid] < array[mid-1] && array[mid] < array[mid+1] (minima point)
            high = mid - 1
        }

    }

    return  -1
}

fun main() {

    val array = intArrayOf(1,2,3,4,10,6,7,8,5,1)
    val array2 = intArrayOf(1)
    println(findAPickElementOptimized(array))
    println(findAPickElement(array2))
}