package tree

class TreeNode<T>(val data: T, var left: TreeNode<T>? = null, var right: TreeNode<T>? = null) {

    val isLeaf: Boolean
        get() = left == null && right == null

    override fun toString() = "{${data}}"
}