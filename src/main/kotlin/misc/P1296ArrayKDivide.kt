package misc

class P1296ArrayKDivide {
    class NumCount(val num: Int, var count: Int = 0)

    fun isPossibleDivide(nums: IntArray, k: Int): Boolean {
        if (nums.size % k != 0) return false
        quickSort(nums, 0, nums.size - 1)
        val l = ArrayList<NumCount>()

        var prev = nums[0]
        var count = 1
        var i = 1
        while (i < nums.size) {
            if (nums[i] == prev) {
                count++
            } else {
                l.add(NumCount(prev, count))
                prev = nums[i]
                count = 1
            }
            i++
        }
        l.add(NumCount(prev, count))

        var i1 = 0
        while (i1 < l.size) {
            try {
                val curr = l[i1].num
                for (j in 0..<k) {
                    val currNumCount = l[i1 + j]
                    if (currNumCount.num != curr + j || currNumCount.count <= 0) return false
                    currNumCount.count--
                }
                while (i1 < l.size && l[i1].count == 0) i1++
                if (i1 == l.lastIndex && l[i1].count == 0) break
            } catch (e: Exception) {
                return false
            }
        }
        return true
    }

    fun quickSort(a: IntArray, s: Int, e: Int) {
        if (s < e) {
            val p = partition(a, s, e)
            quickSort(a, s, p - 1)
            quickSort(a, p + 1, e)
        }
    }

    private fun partition(a: IntArray, l: Int, r: Int): Int {
        val pivot = a[r]
        var firstHigh = l
        while (firstHigh < r && a[firstHigh] <= pivot) {
            firstHigh++
        }
        var i = firstHigh + 1
        while (i < r) {
            if (a[i] < pivot) {
                a.swap(i, firstHigh++)
            }
            i++
        }
        a.swap(firstHigh, r)
        return firstHigh
    }

    fun IntArray.swap(i: Int, j: Int) {
        val t = this[i]
        this[i] = this[j]
        this[j] = t
    }

}

fun main() {
    val arr = intArrayOf(4, 4, 5, 6, 1, 2, 3, 3)
    println("ans = ${P1296ArrayKDivide().isPossibleDivide(arr, 4)}")
}