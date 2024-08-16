package binary_search.striver
/**
 *Bruteforce Approach
 */
fun sqrtNoBinarySearch(n: Int): Int {

    var ans = 0
    for( i in 1..n) {

        if (i*i <= n) {
            ans = i
        } else {
            break
        }
    }

    return ans
}

/**
 *Optimum Approach
 */
fun sqrtNoBinarySearchOpt(n: Int): Int {

    var low = 1
    var high = n
    var ans = 0
    while (low <= high) {

        val mid = (low+high)/2

        if (mid*mid <= n) {
            ans = mid
            low = mid+1
        } else {
            high = mid -1
        }
    }
    return ans
}

fun main() {

    println(sqrtNoBinarySearchOpt(25))
    println(sqrtNoBinarySearch(25))
}