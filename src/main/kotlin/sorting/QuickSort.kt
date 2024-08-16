package sorting

fun quickSort(array: IntArray, l: Int, r: Int) {

    while (l < r) {

        val pivot = partition(array, l, r)
        quickSort(array, l, pivot-1)
        quickSort(array, pivot+1, r)
    }

}


fun partition(array: IntArray, l: Int, r: Int): Int {

    val pivot = array[l]

    var i = l
    var j = r

    while (i < j) {
        while (array[i] <= pivot) { i++ }

        while (array[j] > pivot) { j-- }

        if (i < j) {
            swap(array, i, j)
        }
    }

    swap(array, j, l)

    return j
}


fun swap(array: IntArray, pos1: Int, pos2: Int) {
    val temp = array[pos1]
    array[pos1] = array[pos2]
    array[pos2] = temp
}


fun main() {

    val array = intArrayOf(4,6,2,5,7,9,1,3)
    array.forEach {
        print("$it ")
    }
    println()
    quickSort(array, 0, array.size-1)

    array.forEach {
        print("$it ")
    }
}