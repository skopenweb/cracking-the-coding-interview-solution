package tree

import queues.QueueImpl
import java.util.LinkedList

fun <T> visit(node: TreeNode<T>) {
    print("$node ")
}

fun <T> preOrder(node: TreeNode<T>?) {
    if (node == null) return
    visit(node)
    preOrder(node.left)
    preOrder(node.right)
}

fun <T> postOrder(node: TreeNode<T>?) {
    if (node == null) return
    postOrder(node.left)
    postOrder(node.right)
    visit(node)
}

fun <T> inOrder(node: TreeNode<T>?) {
    if (node == null) return
    inOrder(node.left)
    visit(node)
    inOrder(node.right)
}

fun <T> preOrderIterative(node: TreeNode<T>?) {
    if (node == null) return
}

fun <T> postOrderIterative(node: TreeNode<T>?) {
    if (node == null) return
}

fun <T> inOrderIterative(node: TreeNode<T>?) {
    if (node == null) return
}

fun <T> levelOrderTraversal(node: TreeNode<T>?) {
    if (node == null) return
    var level = 0
    var currLevelCount = 1
    val queue = QueueImpl<TreeNode<T>>().apply {
        enqueue(node)
    }
    val ll = mutableListOf<List<TreeNode<T>>>()
    while (queue.isEmpty().not()) {
        var nextLevelSize = 0
        val l = LinkedList<TreeNode<T>>()
        for (i in 0..<currLevelCount) {
            val currNode = queue.dequeue()
            l.add(currNode)
            with(currNode) {
                left?.let {
                    queue.enqueue(it)
                    nextLevelSize++
                }
                right?.let {
                    queue.enqueue(it)
                    nextLevelSize++
                }
            }
        }
        level++
        print("Level $level => ")
        l.forEach { visit(it) }
        println()
        ll.add(l)
        currLevelCount = nextLevelSize
    }
}


fun main() {
    val n11 = TreeNode(3)
    val n12 = TreeNode(9)
    val n1 = TreeNode(7, left = n11, right = n12)

    val n22 = TreeNode(25)
    val n2 = TreeNode(22, right = n22)

    val root = TreeNode(12, left = n1, right = n2)

    println("PreOrder")
    preOrder(root)
    println("")

    println("PostOrder")
    postOrder(root)
    println("")

    println("InOrder")
    inOrder(root)
    println("")

    levelOrderTraversal(root)
}