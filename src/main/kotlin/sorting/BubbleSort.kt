package sorting


fun IntArray.sortElement() {

    var temp: Int


    for (i in 0..this.lastIndex) {

        for (j in 0..<lastIndex-i) {

            if (this[j] > this[j+1]) {
                temp = this[j+1]
                this[j+1] = this[j]
                this[j] = temp
            }

        }
    }

}

fun main() {

    val array = intArrayOf(8,7,6,5,4,2,1)
    array.sortElement()
    for (i in  array) {
        print(i)
    }

}