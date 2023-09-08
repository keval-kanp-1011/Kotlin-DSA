package array

fun isArrayContainsDuplicateNos(array: Array<Int>): Boolean {

    //Bruteforce approach
//    for (i in array.indices) {
//
//        for (j in i+1..<array.lastIndex) {
//            if (array[i] == array[j]) {
//                return true
//            }
//        }
//
//    }
//
//    return false

    //Optimized Approach

    val hashSet = hashSetOf<Int>()

    for (i in array.indices) {

        if (!hashSet.contains(array[i]))
            hashSet.add(array[i])
        else
            return true
    }

    return true
}