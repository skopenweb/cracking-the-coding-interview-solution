import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ArraysTest {

    @Test
    fun testIsUnique() {
        assertTrue { arrays_1_1_isUnique("abcdef") }
        assertFalse { arrays_1_1_isUnique("abcdefa") }
        assertFalse { arrays_1_1_isUnique("abadef") }
        assertFalse { arrays_1_1_isUnique("abba") }
    }

    @Test
    fun testOneWay() {
        assertTrue(arrays_1_5_oneAway("abcd", "abc"))
        assertTrue(arrays_1_5_oneAway("apple", "aple"))
        assertTrue(arrays_1_5_oneAway("abcra", "bcra"))
        assertTrue(arrays_1_5_oneAway("zzze", "zzzef"))
        assertTrue { arrays_1_5_oneAway("arcade", "barcade") }
        assertTrue { arrays_1_5_oneAway("arcade", "arcode") }

        assertFalse { arrays_1_5_oneAway("arcade", "arcoded") }
        assertFalse { arrays_1_5_oneAway("pale", "bake") }
    }


    @Test
    fun testStringCompression() {
        assertEquals("a3", arrays_1_6_string_Compression("aaa"))
        assertEquals("abc", arrays_1_6_string_Compression("abc"))
        assertEquals("a2b3c4d1", arrays_1_6_string_Compression("aabbbccccd"))
        assertEquals("a3", arrays_1_6_string_Compression("aaa"))
        assertEquals("aabb", arrays_1_6_string_Compression("aabb"))
        assertEquals("aabcc", arrays_1_6_string_Compression("aabcc"))
        assertEquals("a2b2c6", arrays_1_6_string_Compression("aabbcccccc"))
    }
}
