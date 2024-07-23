import kotlin.test.Test

class ArraysTest {

    @Test
    // string has all unique characters
    fun testUniqueTest() {
        val result = arrays_1_1_isUnique("abcdef")
        assert(result)
    }

    @Test
    // string has all unique characters
    fun testUniqueTest2() {
        val result = arrays_1_1_isUnique("abcdefa")
        assert(result.not())
    }

    @Test
    // string has all unique characters 3
    fun testUniqueTest3() {
        val result = arrays_1_1_isUnique("abadef")
        assert(result.not())
    }


    @Test
    // string has all unique characters 3
    fun testUniqueTest4() {
        val result = arrays_1_1_isUnique("abba")
        assert(result.not())
    }
}
