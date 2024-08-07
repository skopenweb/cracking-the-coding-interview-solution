package stacks

class SortStack {
    val stack = Stack<Int>()
    val temp = Stack<Int>()

    fun sortedPush(data: Int) {
        while(!stack.isEmpty && stack.top() > data) {
            temp.push(stack.pop())
        }
        stack.push(data)
        while (temp.isEmpty.not()) {
            stack.push(temp.pop())
        }
    }
}