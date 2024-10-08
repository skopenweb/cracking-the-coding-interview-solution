package misc

import java.util.*

// Input: "21 + 2 * 6 - 4 + 9"
// Output = 38
//
// Num1 -> OP -> Num2 -> result
// 1. Parse the input
//     1.1 Maintain ref from op linked list // +, -, *, /
// 2. Evaluate the linkedList in order
//
enum class Op {
    Div,
    Mult,
    Plus,
    Minus,
    None;

    companion object {
        fun from(c: Char): Op {
            return when (c) {
                '+' -> Op.Plus
                '-' -> Op.Minus
                '*' -> Op.Mult
                '/' -> Op.Div
                else -> Op.None
            }
        }
    }
}

data class Node(var op: Op = Op.None, var num: Int = -1, var next: Node? = null, var prev: Node? = null)

class DoubleLinkedList() {
    var head: Node = Node()
    var tail: Node = Node()

    init {
        head.next = tail
        tail.prev = head
    }

    fun add(num: Int = -1, op: Op = Op.None):Node {
        val n = Node(num = num, op = op)
        n.prev= tail.prev
        n.next = tail
        tail.prev?.next = n
        tail.prev = n
        return n
    }

    fun operate(opNode: Node) {
        val left = opNode.prev
        val right = opNode.next

        var res: Int? = null
        when (opNode.op) {
            Op.None -> {}
            Op.Plus -> {
                if (left != null && right != null) {
                    res = left.num + right.num
                }
            }

            Op.Minus -> {
                if (left != null && right != null) {
                    res = left.num - right.num
                }
            }

            Op.Mult -> {
                if (left != null && right != null) {
                    res = left.num * right.num
                }
            }

            Op.Div -> {
                if (left != null && right != null) {
                    res = left.num / right.num
                }
            }
        }
        val newNode = Node(num = res ?: 0, prev = left?.prev, next = right?.next)
        left?.prev?.next = newNode
        right?.next?.prev = newNode
    }

}

class Calculator {

    fun solve(expr: String): Int {
        val opList = listOf(LinkedList<Node>(), LinkedList<Node>(), LinkedList<Node>(), LinkedList<Node>())
        val list = DoubleLinkedList()

        parse(expr, opList, list)
        val result = solve(opList, list)

        return result
    }

    private fun parse (expr: String, opList: List<LinkedList<Node>>, tokens: DoubleLinkedList) {
        var i = 0
        var num = 0
        var state = 0 // 0 - num, 1 - operation
        while(i < expr.length) {
            if (state == 0) {
                if (expr[i] in '0'..'9') {
                    num = num*10 + (expr[i] - '0')
                    i++
                } else {
                    tokens.add(num = num)
                    state = 1
                    num = 0
                }
            } else if (state == 1) {
                if (expr[i] in "+-/*") {
                    val op = Op.from(expr[i])
                    val n = tokens.add(op = op)
                    opList[op.ordinal].add(n)
                    i++
                } else if (expr[i] in '0'..'9' ) {
                    state = 0
                } else {
                    i++
                }
            }
        }
        tokens.add(num)
    }

    private fun solve(opLists: List<LinkedList<Node>>, tokens: DoubleLinkedList) : Int {
        for (opList in opLists) {
            for (op in opList) {
                tokens.operate(op)
            }
        }
        return tokens.head.next?.num ?: 0
    }
}

fun main() {
    val input =  "1-9*12/3"
    val ans = Calculator().solve(input)
    println("ans = $ans")
}