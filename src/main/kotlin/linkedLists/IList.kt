package linkedLists

internal interface IList {
    val size: Int
    fun isEmpty(): Boolean
    fun add(n: Node): LinkedList
    fun remove(v: Int): Node?
}