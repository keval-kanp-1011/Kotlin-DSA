package sorting

fun mergeSort(array: IntArray, l: Int, r: Int) {


    if (l < r){
        val mid =  (l+r)/2
        mergeSort(array,l, mid)
        mergeSort(array, mid+1, r)
        merge(array, l, mid, r)
    }
}


fun merge(array: IntArray, l: Int, mid: Int, r: Int) {

    var i: Int = l
    var j: Int = mid+1
    var k: Int = l

    val b = arrayOfNulls<Int>(array.size)
    while (i <= mid && j <= r) {
        if (array[i] > array[j]) {
            b[k] = array[j]
            j++
        } else {
            b[k] = array[i]
            i++
        }
        k++
    }

    if (i > mid) {
        while (j <= r) {
            b[k] = array[j]
            j++
            k++
        }
    } else {
        while (i <= mid) {
            b[k] = array[i]
            i++
            k++
        }
    }

    for (k in l..r) {
        array[k] = b[k]!!
    }
}


fun main() {
    val array = intArrayOf(8,4,1,5,9,2)

    mergeSort(array, 0, array.size-1)

    array.forEach {
        print("$it ")
    }
}