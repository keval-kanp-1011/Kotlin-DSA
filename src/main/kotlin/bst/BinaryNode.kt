package bst

typealias Visitor<T> = (T) -> Unit

class BinaryNode<T: Comparable<T>>(var value: T) {

    var leftChild: BinaryNode<T>? = null
    var rightChild: BinaryNode<T>? = null

    val min: BinaryNode<T>?
        get() = leftChild?.min ?: this

    val isBinarySearchTree: Boolean
        get() = isBST(this, min = null, max = null)

    private fun isBST(tree: BinaryNode<T>?, min: T?, max: T?): Boolean {
// 2
        tree ?: return true
// 3
        if (min != null && tree.value <= min) {
            return false
        } else if (max != null && tree.value > max) {
            return false
// 4
        }
        return isBST(tree.leftChild, min, tree.value) && isBST(tree.rightChild, tree.value, max)
    }


    fun traverseInOrder(visit: Visitor<T>) {
        leftChild?.traverseInOrder(visit)
        visit(value)
        rightChild?.traverseInOrder(visit)
    }

    fun traversePreOrder(visit: Visitor<T>) {
        visit(value)
        leftChild?.traversePreOrder(visit)
        rightChild?.traversePreOrder(visit)
    }


    fun traversePostOrder(visit: Visitor<T>) {
        leftChild?.traversePostOrder(visit)
        rightChild?.traversePostOrder(visit)
        visit(value)
    }

    fun height(node: BinaryNode<T>? = this): Int {
        return node?.let { 1 + maxOf(height(node.leftChild),
            height(node.rightChild)) } ?: -1
    }




    override fun toString() = diagram(this)

    private fun diagram(node: BinaryNode<T>?,
                        top: String = "",
                        root: String = "",
                        bottom: String = ""): String {
        return node?.let {
            if (node.leftChild == null && node.rightChild == null) {
                "$root${node.value}\n"
            } else {
                diagram(node.rightChild, "$top ", "$top┌──", "$top│ ") +
                        root + "${node.value}\n" + diagram(node.leftChild,
                    "$bottom│ ", "$bottom└──", "$bottom ")
            }
        } ?: "${root}null\n"
    }

    override fun equals(other: Any?): Boolean {
        return if (other != null && other is BinaryNode<*>) {
            this.value == other.value &&
                    this.leftChild == other.leftChild &&
                    this.rightChild == other.rightChild
        }
        else {
            false
        }
    }


}

fun main() {

    val zero = BinaryNode(0)
    val one = BinaryNode(1)
    val five = BinaryNode(5)
    val seven = BinaryNode(7)
    val eight = BinaryNode(8)
    val nine = BinaryNode(9)
    seven.leftChild = one
    one.leftChild = zero
    one.rightChild = five
    seven.rightChild = nine
    nine.leftChild = eight
    val tree = seven

    println(tree)

}