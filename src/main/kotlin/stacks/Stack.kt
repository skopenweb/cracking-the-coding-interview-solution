package stacks

class Stack<T : Any> : IStack<T> {

    private var currSize: Int = 0
    private val items = Array<Any>(MAXSIZE){}

    companion object {
        const val MAXSIZE = 100
    }

    override val isEmpty: Boolean
        get() = size == 0

    override val size: Int
        get() = currSize

    override fun pop(): T {
        if (isEmpty) throw IllegalStateException("empty stack")
        val top = items[currSize - 1]
        currSize--
        return top as T
    }

    override fun push(data: T): IStack<T> {
        if (currSize == MAXSIZE) throw  IllegalStateException("overflow")
        items[currSize++] = data
        return this
    }

    override fun top(): T {
        if (isEmpty) throw IllegalStateException("underflow")
        return items[currSize - 1] as T
    }
}

fun main() {
    val s = Stack<Int>()

    s.push(100).push(90)
    println(s.size)
    println(s.top())
    s.pop()
    println(s.top())
    s.pop()
    println(s.isEmpty)
}



