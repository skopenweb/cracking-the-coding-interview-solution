package stacks

interface IStack<T> {
    val isEmpty: Boolean
    val size: Int
    fun top(): T
    fun push(data: T): IStack<T>
    fun pop(): T
}