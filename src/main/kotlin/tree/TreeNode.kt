package tree

open class TreeNode<T>(open val data: T, open var left: TreeNode<T>? = null, open var right: TreeNode<T>? = null) {

    val isLeaf: Boolean
        get() = left == null && right == null

    override fun toString() = "{${data}}"
}

class TreeNodeWithParent<T>(
    val data: T,
    var left: TreeNodeWithParent<T>? = null,
    var right: TreeNodeWithParent<T>? = null,
    var parent: TreeNodeWithParent<T>? = null
)