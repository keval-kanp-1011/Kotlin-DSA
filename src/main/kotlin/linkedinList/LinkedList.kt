package linkedinList

class LinkedList<T> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0

    fun isEmpty() = size == 0

    override fun toString(): String {
        return if (isEmpty()) {
            "Empty List"
        } else {
            head.toString()
        }
    }


    fun push(value: T) {

        head = Node(value, head)

        if (tail == null) {
            tail = head
        }

        size++
    }

    fun push2(value: T): LinkedList<T> {

        head = Node(value, head)

        if (tail == null) {
            tail = head
        }

        size++

        return this
    }

    fun append(value: T) {

        if (isEmpty()) {
            push(value)
            return
        }
        tail?.next = Node(value)
        tail = tail?.next

        size++
    }


    fun nodeAt(index: Int): Node<T>? {

        var currentIndex = 0
        var currentNode: Node<T>? = head?.next

        while (currentNode == null && currentIndex < index) {
            currentNode = currentNode?.next
            currentIndex++

        }

        return currentNode

    }


    fun insert(value: T, afterNode: Node<T>): Node<T> {

        if (tail == afterNode) {
            append(value)
            return tail!!
        }
        val next = afterNode.next
        val nodeToInsert =Node(value, next)
        afterNode.next = nodeToInsert

        size++
        return nodeToInsert
    }

    fun pop(): T? {

        if (!isEmpty()) size--
        val result = head?.value

        head = head?.next
        if (isEmpty()) {
            tail = null
        }

        return result
    }

    fun removeLast(): T? {

        val head = head ?: return null

        if (head.next == null) pop()

        size--

        var prev = head
        var current = head

        var next = current.next

        while (next != null) {
            prev = current
            current = next
            next = current.next

        }

        prev.next = null
        tail = prev
        return current.value
    }
}
