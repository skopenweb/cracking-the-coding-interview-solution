//package sortingSearching
//
//import prettyPrint
//
//fun countingSort(arr: IntArray) {
//    var min = arr[0]
//    var max = arr[0]
//
//    for (i in 1..<arr.size) {
//        min = min.coerceAtMost(arr[i])
//        max = max.coerceAtLeast(arr[i])
//    }
//    println("min = $min, max = $max")
//    val countArray = IntArray(max - min + 1)
//
//    for (e in arr) {
//        val index = e - min
//        countArray[index]++
//    }
//    var index = 0
//    for (i in countArray.indices) {
//        repeat(countArray[i]) {
//            arr[index++] = min + index
//        }
//    }
//    //arr.prettyPrint()
//}
//
//class LNode(val data: Int, var next: LNode? = null)
//
//fun IntArray.bucketSort(k: Int) {
//    var max = this[0]
//    var min = this[0]
//    for (i in 1..<this.size) {
//        min = min.coerceAtMost(this[i])
//        max = max.coerceAtLeast(this[i])
//    }
//    val list = Array<LNode?>(k) { null }
//    for (e in this) {
//        val index = (((e - min) / (1.0 * (max - min + 1))) * k).toInt()
//        addToList(list, index, e)
//    }
//    var index = 0
//    for (node in list) {
//        var curr = node
//        while (curr != null) {
//            this[index++] = curr.data
//            curr = curr.next
//        }
//    }
//}
//
//fun addToList(list: Array<LNode?>, index: Int, e: Int) {
//    if (list[index] == null) {
//        list[index] = LNode(data = e)
//    } else {
//        var curr = list[index]
//        if (curr?.data!! > e) {
//            val newNode = LNode(data = e, next = curr)
//            list[index] = newNode
//        } else {
//            while (curr?.next != null && curr.next!!.data < e) {
//                curr = curr.next
//            }
//            val newNode = LNode(data = e, next = curr?.next)
//            curr?.next = newNode
//        }
//    }
//}
//
//fun IntArray.radixSort() {
//
//    // 122, 23,
//    var power = 1
//    var num = 10
//    var max = this.fold(Integer.MIN_VALUE) { acc: Int, i: Int -> acc.coerceAtLeast(i) }
//    val countArray = IntArray(10)
//    while (max/power > 0) {
//        for (i in this.indices) {
//            val index = this[i] % num
//            countArray[index]++
//        }
//        var j = 0
//        for (i in countArray.indices) {
//            repeat(countArray[i]) {
//                this[]
//            }
//        }
//    }
//}
//
//fun main() {
//    val arr = intArrayOf(12, 14, 10, 9, 8, 7, 21, 20, 21)
////    countingSort(arr)
//    arr.bucketSort(2)
//    arr.prettyPrint()
//}