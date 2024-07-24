import kotlin.test.Test

class ArraysTest {

    @Test
    fun testUniqueTest() {
        val result = arrays_1_1_isUnique("abcdef")
        assert(result)
    }

    @Test
    fun testUniqueTest2() {
        val result = arrays_1_1_isUnique("abcdefa")
        assert(result.not())
    }

    @Test
    fun testUniqueTest3() {
        val result = arrays_1_1_isUnique("abadef")
        assert(result.not())
    }

    @Test
    fun testUniqueTest4() {
        val result = arrays_1_1_isUnique("abba")
        assert(result.not())
    }
}
