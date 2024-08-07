package queues

import stacks.Stack

interface IQueue {
    val size: Int
    fun peek(): Int
    fun enqueue(item: Int)
    fun dequeue()
}

class MyQueue2Stacks : IQueue {
    val stack1 = Stack<Int>()
    val stack2 = Stack<Int>()

    companion object {
        const val MAX_SIZE = 10
    }

    override val size: Int
        get() = stack1.size

    override fun peek() = stack1.top()

    override fun enqueue(item: Int) {
        stack1.push(item)
    }

    override fun dequeue() {
        while (stack1.isEmpty.not()) {
            stack2.push(stack1.pop())
        }
        stack2.pop()
        while (stack2.isEmpty.not()) {
            stack1.push(stack2.pop())
        }
    }
}