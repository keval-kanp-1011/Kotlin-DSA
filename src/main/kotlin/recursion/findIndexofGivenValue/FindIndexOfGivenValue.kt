package recursion.findIndexofGivenValue

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