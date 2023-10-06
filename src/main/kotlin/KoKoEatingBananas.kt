import kotlin.math.ceil

fun noOfHoursToEatBananas(piles: IntArray, hourlyRate: Int): Int {

    var ans = 0
    for (i in piles) {
        ans += ceil(i.toDouble() / hourlyRate.toDouble()).toInt()
    }

    return ans

}

fun minRateToEatBananas(piles: IntArray, h: Int): Int {

    var low = 1
    var high = piles.last()


    while (low <= high) {

        val mid = (low+high)/2

        if (noOfHoursToEatBananas(piles, mid) == h) return mid

        if (noOfHoursToEatBananas(piles, mid) <= h) {
            high = mid -1
        } else {
            low = mid+1
        }


    }

    return -1

}

fun main() {

    println(minRateToEatBananas(intArrayOf(3,6,7,11), 8))
}