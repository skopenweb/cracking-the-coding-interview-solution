package sorting

import prettyPrint
import sortingSearching.myQuicksort
import kotlin.test.Test
import kotlin.test.assertTrue

class SortingTest {

    @Test
    fun testQuickSort(): Unit {
        val array = arrayOf(2, 10, 2, 10, 1, 2,)
        array.prettyPrint()
        myQuicksort(array)
        array.forEach{print(" $it")}
        var curr = 1
        while (curr < array.size) {
            assertTrue{ array[curr] >= array[curr -1] }
            curr++
        }
    }
}