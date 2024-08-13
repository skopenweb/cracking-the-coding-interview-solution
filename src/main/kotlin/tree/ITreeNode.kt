package tree


interface ITreeNode<T> {
    val data: T
    var left: ITreeNode<T>
    var right: ITreeNode<T>

    val isLeaf: Boolean
}