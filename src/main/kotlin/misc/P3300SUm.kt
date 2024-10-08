package misc

class P3300Sum {
    fun minElement(nums: IntArray): Int {
        return  nums.fold(Integer.MIN_VALUE){ a, b -> a.coerceAtMost(b.sum())}
    }

    private fun Int.sum(): Int {
        var sum = 0
        var curr = this
        while(curr > 0) {
            sum += curr%10
            curr /= 10
        }
        return sum
    }
}