package stacks

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



