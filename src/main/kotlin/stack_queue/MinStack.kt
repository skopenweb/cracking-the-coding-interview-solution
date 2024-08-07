package stack_queue

interface IMinStack {
    val min: Int
    val isEmpty: Boolean
    val size: Int

    fun push(item: Int)
    fun pop(): Int
}

class MinStack : IMinStack {

    private var _min: Int = 0
    private var _size: Int = 0
    private var _items = IntArray(MAX_SIZE)

    companion object {
        const val MAX_SIZE = 100
    }

    override val min: Int
        get() = if (size == 0) throw IllegalStateException("empty stack") else _min
    override val isEmpty: Boolean
        get() = size == 0
    override val size: Int
        get() = _size

    override fun push(item: Int) {
        if (_size > MAX_SIZE) throw IllegalStateException("overflow")
        _items[_size] = item
        _size++

        if (item < _min) {
            _min = item
        }
    }

    override fun pop(): Int {
        if (isEmpty) throw IllegalStateException("underflow")
        val top = _items[_size - 1]
        _size--

        if (top == _min) {
            _min = _items[_size - 1]
            var i = _size - 2
            while (i >= 0) {
                if (_items[i] < _min) {
                    _min = _items[i]
                }
                i--
            }
        }
        return top
    }
}