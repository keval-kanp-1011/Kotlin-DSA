package recursion


fun findSum(array: IntArray,ans: IntArray, sum: Int): IntArray{

    val and1 = intArrayOf(0)


    for (i in 0..<array.size) {

        if (array[i] != -1) {
            val a = array[i]

            array[i] = -1

            ans + (sum+a)

//            for (i in oo) {
//                print("$i ")
//            }
            //println(oo)

            findSum(array, ans, sum+a)
            array[i] = a
        }


    }


    //sum[] = {0,1}
    //array[] = {-1,2,3,4,5}

    return ans

}

fun subsetHelper(ind: Int , sum: Int, array: MutableList<Int>, ans: MutableList<Int>) {

    if (ind == array.size) {
        ans.add(sum)
        return
    }

    subsetHelper(ind+1, sum + array[ind], array, ans)

    subsetHelper(ind+1, sum, array, ans)
}

fun subsetSums(arr: MutableList<Int>): MutableList<Int> {
    val sumSubset = mutableListOf<Int>()
    subsetHelper(0, 0, arr, sumSubset)

    return sumSubset
}

fun main() {

    val array = arrayListOf(3,1,2)
    val ans = subsetSums(array)
    ans.sort()

    //val ans = findSum(array, intArrayOf(0), 0)

    for (i in ans) {
        print("$i ")
    }


}