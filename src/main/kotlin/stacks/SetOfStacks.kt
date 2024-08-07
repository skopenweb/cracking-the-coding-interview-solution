package stacks

import java.lang.IllegalArgumentException

interface ISetOfStacks {
    fun push(item: Int)
    fun pop(): Int
    fun popAt(index: Int): Int
}

class SetOfStacks(val batchSize: Int = 100) : ISetOfStacks {

    private val stackList = mutableListOf<Array<Int>>()
    private var sizes = mutableListOf<Int>()
    override fun push(item: Int) {
        var availableIndex = -1
        sizes.forEachIndexed { index, i ->
            if (i < batchSize) availableIndex = index
        }
        if (availableIndex == -1) {
            sizes.add(0)
            availableIndex = sizes.size - 1
        }
        val currSize = sizes[availableIndex]
        if (currSize == 0) {
            val items = Array(batchSize) { 0 }
            items[0] = item
            if (availableIndex in 0..<stackList.size) {
                stackList[availableIndex] = items
            } else {
                stackList.add(items)
            }
            sizes[availableIndex] = 1
        } else {
            stackList[availableIndex][sizes[availableIndex]] = item
            sizes[availableIndex]++
        }
    }

    override fun pop(): Int {
        var index = -1
        for (i in sizes.size - 1 downTo 0) {
            if (sizes[i] > 0) {
                index = i
                break
            }
        }
        if (index == -1) throw IllegalStateException("underflow")
        val item = stackList[index][sizes[index] - 1]
        sizes[index] -= 1

        if (sizes[index] == 0) {
            sizes.removeAt(index)
            stackList.removeAt(index)
        }
        return item
    }

    override fun popAt(index: Int): Int {
        if (index < 0 || index >= stackList.size || sizes[index] == 0)
            throw IllegalArgumentException("illegal index")
        val item = stackList[index][sizes[index] - 1]
        sizes[index]--
        return item
    }

    init {
        if (batchSize <= 0) throw IllegalArgumentException("batchSize shall be positive")
    }
}

fun main() {
    println("setOfStacks")

    val ss = SetOfStacks(2)
    ss.apply {
        push(99)
        push(89)
        push(79)
        println(pop())
        println(pop())
        println(pop())
        for (i in 101..105) {
            push(i)
        }
        println(popAt(1))
        println(popAt(1))
        push(55)
        push(56)
    }
}