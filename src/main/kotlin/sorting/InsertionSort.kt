package sorting

fun insertionSort(
    array: IntArray
) {


    for(i in 1..<array.size) {

        val temp = array[i]

        var j = i-1
        while (j >= 0 && array[j] > temp) {
            array[j+1] = array[j]
            j--
        }
        if (array[j+1] != temp) {
            array[j+1] = temp
        }



    }
}


fun main() {

    val sample: IntArray = intArrayOf(8,4,1,5,9,2)
    insertionSort(sample)
    sample.forEach {
        print("$it ")
    }


}