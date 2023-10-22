package twosum

fun twoSum(nums: IntArray, target: Int): IntArray {

    val s = hashSetOf<Int>()

    for (i in nums) {

        println(i)

        if (!s.contains(i)) {
            s.add(i)

        }


        if (i < target) {
            println(" $i is less han $target")


            if (s.contains(target - i)) {


                println("s contains ${target - i}")
                val s = nums.indexOf(i)
                val e = nums.indexOf(target-i)
                println(s)
                println(e)

                if ((target - i) != i) {
                    if (s < e) {
                        return intArrayOf(s,e)
                    } else {
                        return intArrayOf(e, s)
                    }
                } else {

                }





            }
        }

    }

    return intArrayOf(0,0)



}

fun main() {

    val ans = intArrayOf(1,2,3,4,5,6,7,8,9)



}