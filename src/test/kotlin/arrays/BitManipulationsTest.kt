package arrays

import bitmanipulation.bit_manipulations_5_1_insertions
import bitmanipulation.bit_manipulations_5_3_flipToWin
import kotlin.test.Test
import kotlin.test.assertEquals

class BitManipulationsTest {

    @Test
    fun test_5_1_insertions() {
        val N = 0b100000
        val M = 0b101

        val ans = bit_manipulations_5_1_insertions(N, M, 2, 4)

        assertEquals(ans, 0b110100)
    }

    @Test
    fun test_5_3_FlipBitToWin() {
        val input = 0b110_1110_1111

        assertEquals(8, bit_manipulations_5_3_flipToWin(input), "shall be equals")
        assertEquals(8, bit_manipulations_5_3_flipToWin(127), "shall be equals")
        assertEquals(3, bit_manipulations_5_3_flipToWin(12), "shall be equals")
        assertEquals(4, bit_manipulations_5_3_flipToWin(7), "shall be equals")
        assertEquals(2, bit_manipulations_5_3_flipToWin(1), "shall be equals")
        assertEquals(2, bit_manipulations_5_3_flipToWin(8), "shall be equals")
        assertEquals(32, bit_manipulations_5_3_flipToWin(0.inv()), "shall be equals")
    }


}
