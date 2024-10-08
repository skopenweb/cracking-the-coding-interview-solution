package misc.contest418

class Contest418 {

    fun maxGoodNumber(nums: IntArray): Int {
        val result = intArrayOf(Integer.MIN_VALUE)
        val sizes = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            sizes[nums[i]] = nums[i].binarySize()
        }
        bruteForce(0, nums, 0, sizes, result)
        return result[0]
    }

    fun Int.binarySize(): Int {
        var curr = this
        var count = 0
        while (curr > 0) {
            count++
            curr = curr shr 1
        }
        return count
    }

    fun bruteForce(currNum: Int, nums: IntArray, index: Int, sizes: Map<Int, Int>, result: IntArray) {
        if (index == nums.size) {
            if (currNum > result[0]) {
                result[0] = currNum
            }
            return
        }
        for (j in index..<nums.size) {
            nums.swap(index, j)
            val newNum = (currNum shl sizes[nums[index]]!!) + nums[index]
            bruteForce(newNum, nums, index + 1, sizes, result)
            nums.swap(index, j)
        }
        return
    }

    fun IntArray.swap(i: Int, j: Int) {
        if (i == j) return
        val t = this[i]
        this[i] = this[j]
        this[j] = t
    }
}

fun main() {
//    val ans = Contest418().maxGoodNumber(intArrayOf(1, 2, 3))
    val ans2 = Contest418().maxGoodNumber(intArrayOf(2, 91, 119))
    println(ans2)
}