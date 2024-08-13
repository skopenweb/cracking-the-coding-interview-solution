package tree

class TreeNode<T>(val data: T, var left: TreeNode<T>? = null, var right: TreeNode<T>? = null) {

    val isLeaf: Boolean
        get() = left == null && right == null

    override fun toString() = "{${data}}"
}

fun <T> visit(node: ITreeNode<T>) {
    println(node)
}

fun <T> preOrder(node: ITreeNode<T>?) {
    if (node == null) return
    visit(node)
    preOrder(node.left)
    preOrder(node.right)
}

fun <T> postOrder(node: ITreeNode<T>?) {
    if (node == null) return
    postOrder(node.left)
    postOrder(node.right)
    visit(node)
}

fun <T> inOrder(node: ITreeNode<T>?) {
    if (node == null) return
    inOrder(node.left)
    visit(node)
    inOrder(node.right)
}

fun <T> preOrderIterative(node: ITreeNode<T>?) {
    if (node == null) return
}

fun <T> postOrderIterative(node: ITreeNode<T>?) {
    if (node == null) return
}

fun <T> inOrderIterative(node: ITreeNode<T>?) {
    if (node == null) return
}

fun <T> leveOrderTraversal(node: ITreeNode<T>?) {
    if (node == null) return


}