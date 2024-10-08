package misc

class P560NumOfSubArray {

    fun subarraySum(nums: IntArray, k: Int): Int {
        var counter = 0
        var sum = 0
        val map = hashMapOf<Int, Int>()
        map[0] = 1

        for (num in nums) {
            sum += num

            counter += map.getOrDefault(sum - k, 0)
            map[sum] = map.getOrDefault(sum, 0) + 1
        }
        return counter
//        val map = HashMap<Int, Int>()
//        var sum = 0
//        var count = 0
//        for (i in nums.indices) {
//            sum += nums[i]
//            val countLessK = map[sum - k]
//            if (countLessK != null) {
//                count += countLessK
//            }
//            if (sum == k) {
//                count++
//            }
//            map[sum] = (map[sum] ?: 0) + 1
//        }
//        return count
        // var count = 0
        // for (i in 0..<nums.size) {
        //     var sum = 0
        //     for (j in i..<nums.size) {
        //         sum += nums[j]
        //         if (sum == k) count++
        //     }
        // }
        // return count
    }
}

fun main() {
    val arr = intArrayOf(1)
    val k = 0
    val result = P560NumOfSubArray().subarraySum(arr, k)
    println("result $result")
}