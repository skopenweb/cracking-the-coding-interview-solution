package misc

import java.util.*

class P164MaximumGap {
    fun maximumGap(nums: IntArray): Int {
        if (nums.size < 2) return 0
        Arrays.sort(nums)
        var i = 1
        var ans = 0
        while(i < nums.size) {
            ans = ans.coerceAtLeast(nums[i] - nums[i-1])
            i++
        }
        return ans
    }
}