package binary_search.striver

fun findIndex( nums: IntArray, start: Int, end: Int, target: Int): Int {

    val mid = (start + end)/2

    if (nums[mid] == target) return mid

    if (nums[mid] > target) {
        return findIndex(nums, start, mid-1, target)
    }

    if (nums[mid] < target) {
        return findIndex(nums, mid+1, end, target)
    }

    return  -1
}

fun main() {

    val ans = intArrayOf(1,2,3,4,5,6,7,8,9)

    println(findIndex(ans, 0, ans.size -1, 3))


}