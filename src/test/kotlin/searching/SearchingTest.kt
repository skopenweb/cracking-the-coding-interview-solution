package searching

import org.junit.jupiter.api.Assertions.assertEquals
import prettyPrint
import sortingSearching.lps
import kotlin.test.Test

class SearchingTest {

    @Test
    fun testKmpSearch(): Unit {
        val input = "ABABCA"
        val actual = lps(input)
        val expected = listOf(0, 0, 1, 2, 0, 1)
        actual.prettyPrint()
        expected.prettyPrint()

        expected.forEachIndexed { index, item ->
            assertEquals(actual[index], expected[index])
        }
    }

    @Test
    fun testKmpSearch2(): Unit {
        val input = "AABAACAABAA"
        val actual = lps(input)
        val expected = listOf(0, 1, 0, 1, 2, 3, 4, 5, 6, 7, 8)
        actual.prettyPrint()
        expected.prettyPrint()

        expected.forEachIndexed { index, item ->
            assertEquals(actual[index], expected[index])
        }
    }
}