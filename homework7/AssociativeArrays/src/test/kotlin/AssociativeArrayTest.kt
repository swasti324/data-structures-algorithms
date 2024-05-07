import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Test cases for the AssociativeArray class.
 */
class AssociativeArrayTest {

    /**
     * Tests the set function of AssociativeArray.
     * Args:
     *   None
     * Returns:
     *   None
     */
    @Test
    fun testSet() {
        val map = AssociativeArray<String, Int>()

        map["key1"] = 1
        map["key2"] = 2
        map["key3"] = 3

        assertEquals(3, map.size())
        assertTrue("key1" in map)
        assertTrue("key2" in map)
        assertTrue("key3" in map)
    }

    /**
     * Tests the contains function of AssociativeArray.
     * Args:
     *   None
     * Returns:
     *   None
     */
    @Test
    fun testContains() {
        val map = AssociativeArray<String, Int>()

        map["key1"] = 1
        map["key2"] = 2

        assertTrue("key1" in map)
        assertTrue("key2" in map)
        assertFalse("key3" in map)
    }

    /**
     * Tests the get function of AssociativeArray.
     * Args:
     *   None
     * Returns:
     *   None
     */
    @Test
    fun testGet() {
        val map = AssociativeArray<String, Int>()

        map["key1"] = 1
        map["key2"] = 2

        assertEquals(1, map["key1"])
        assertEquals(2, map["key2"])
        assertNull(map["key3"])
    }

    /**
     * Tests the remove function of AssociativeArray.
     * Args:
     *   None
     * Returns:
     *   None
     */
    @Test
    fun testRemove() {
        val map = AssociativeArray<String, Int>()

        map["key1"] = 1
        map["key2"] = 2

        assertTrue(map.remove("key1"))
        assertFalse(map.remove("key3"))
        assertNull(map["key1"])
        assertEquals(1, map.size())
    }

    /**
     * Tests the remove function of AssociativeArray for multiple removals.
     * Args:
     *   None
     * Returns:
     *   None
     */
    @Test
    fun testRemoveMult() {
        val map = AssociativeArray<String, Int>()

        map["key1"] = 1
        map["key2"] = 2
        map["key3"] = 3

        assertTrue(map.remove("key1"))
        assertTrue(map.remove("key2"))
        assertTrue(map.remove("key3"))
        assertEquals(0, map.size())
    }

    /**
     * Tests the size function of AssociativeArray.
     * Args:
     *   None
     * Returns:
     *   None
     */
    @Test
    fun testSize() {
        val map = AssociativeArray<String, Int>()

        assertEquals(0, map.size())

        map["key1"] = 1
        map["key2"] = 2

        assertEquals(2, map.size())

        map.remove("key1")

        assertEquals(1, map.size())
    }

    /**
     * Tests the keyValuePairs function of AssociativeArray.
     * Args:
     *   None
     * Returns:
     *   None
     */
    @Test
    fun testKeyValuePairs() {
        val map = AssociativeArray<String, Int>()

        map["key1"] = 1
        map["key2"] = 2

        val pairs = map.keyValuePairs()

        assertEquals(2, pairs.size)
        assertTrue(pairs.contains("key1" to 1))
        assertTrue(pairs.contains("key2" to 2))
    }

}
