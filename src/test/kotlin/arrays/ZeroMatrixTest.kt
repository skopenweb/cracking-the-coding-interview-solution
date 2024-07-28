package arrays

import arrays_1_8_zero_matrix
import kotlin.test.Test
import kotlin.test.assertContentEquals

class ZeroMatrixTest {

    @Test
    fun `test arrays_1_8_zero_matrix with no zeroes`() {
        val matrix = arrayOf(
            intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9)
        )
        val expected = arrayOf(
            intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9)
        )
        arrays_1_8_zero_matrix(matrix)
        matrix.forEachIndexed { index, array ->
            assertContentEquals(expected[index], matrix[index])
        }
    }

    @Test
    fun `test arrays_1_8_zero_matrix with one zero`() {
        val matrix = arrayOf(
            intArrayOf(1, 2, 0), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9)
        )
        val expected = arrayOf(
            intArrayOf(0, 0, 0), intArrayOf(4, 5, 0), intArrayOf(7, 8, 0)
        )
        arrays_1_8_zero_matrix(matrix)
        matrix.forEachIndexed { index, array ->
            assertContentEquals(expected[index], matrix[index])
        }
    }

    @Test
    fun `test arrays_1_8_zero_matrix with multiple zeroes`() {
        val matrix = arrayOf(
            intArrayOf(1, 0, 3), intArrayOf(0, 5, 6), intArrayOf(7, 8, 0)
        )
        val expected = arrayOf(
            intArrayOf(0, 0, 0), intArrayOf(0, 0, 0), intArrayOf(0, 0, 0)
        )
        arrays_1_8_zero_matrix(matrix)
        matrix.forEachIndexed { index, array ->
            assertContentEquals(expected[index], matrix[index])
        }
    }

    @Test
    fun `test arrays_1_8_zero_matrix with all zeroes`() {
        val matrix = arrayOf(
            intArrayOf(0, 0, 0), intArrayOf(0, 0, 0), intArrayOf(0, 0, 0)
        )
        val expected = arrayOf(
            intArrayOf(0, 0, 0), intArrayOf(0, 0, 0), intArrayOf(0, 0, 0)
        )
        arrays_1_8_zero_matrix(matrix)
        matrix.forEachIndexed { index, array ->
            assertContentEquals(expected[index], matrix[index])
        }
    }

    @Test
    fun `test arrays_1_8_zero_matrix with empty matrix`() {
        val matrix = emptyArray<IntArray>()
        arrays_1_8_zero_matrix(matrix)

        val expected = emptyArray<IntArray>()

        expected.forEachIndexed { index, row ->
            assertContentEquals(row, matrix[index])
        }
    }

    @Test
    fun `test arrays_1_8_zero_matrix with single element matrix`() {
        val matrix = arrayOf(intArrayOf(1))
        arrays_1_8_zero_matrix(matrix)
        val expected = arrayOf(intArrayOf(1))

        expected.forEachIndexed { index, row ->
            assertContentEquals(row, matrix[index])
        }
    }
}