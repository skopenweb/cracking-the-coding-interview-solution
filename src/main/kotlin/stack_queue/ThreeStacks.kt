package stack_queue

import stack_queue.Stack.Companion.MAXSIZE

interface IThreeStacks {
    fun push(item: Int, into: Int)

    fun pop(from: Int): Int

    fun size(of: Int): Int

    fun isEmpty(of: Int): Boolean
}

class ThreeStacks : IThreeStacks {

    val arr = Array<Int>(MAXSIZE * 3) { 0 }
    val sizes = Array<Int>(3) { 0 }

    companion object {
        const val MAXSIZE: Int = 100
    }

    override fun push(item: Int, into: Int) {
        val newIndex = sizes[into] * 3 + into
        if (newIndex >= Stack.MAXSIZE) throw IllegalStateException("overflow")
        arr[newIndex] = item
        sizes[into] += 1
    }

    override fun pop(from: Int): Int {
        val currSize = sizes[from]
        if (currSize == 0) throw IllegalStateException("underflow")

        val topIndex = (currSize - 1) * 3 + from
        val top = arr[topIndex]

        sizes[from] -= 1
        return top
    }

    override fun size(of: Int): Int = sizes[of]

    override fun isEmpty(of: Int) = size(of) == 0
}