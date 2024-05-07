import kotlin.math.absoluteValue

/**
 Represents a mapping of keys to values.
 Args:
    K the type of the keys
    V the type of the values
 */
class AssociativeArray<K, V> {
    private var capacity = 16
    private var size = 0
    private var array = Array<MutableMap<K, V>>(capacity) { mutableMapOf() }

    /**
     * Inserts a mapping from a key to a value.
     * If the key already exists, replaces the existing mapping.
     * Args:
     *   k: Key to be inserted.
     *   v: Value to be associated with the key.
     */
    operator fun set(k: K, v: V) {
        if (size >= capacity * 0.75) {
            resize()
        }
        val index = getIndex(k)
        var map = array[index]
        if (map.containsKey(k)) {
            map[k] = v
        } else {
            map[k] = v
            size++
        }
    }

    /**
     * Checks if a key exists in the associative array.
     * Args:
     *   k: Key to check for existence.
     * Returns:
     *   Boolean value indicating if the key exists.
     */
    operator fun contains(k: K): Boolean {
        val index = getIndex(k)
        return array[index].containsKey(k)
    }

    /**
     * Retrieves the value associated with a key.
     * Args:
     *   k: Key whose associated value is to be retrieved.
     * Returns:
     *   The value associated with the key, or null if the key is not found.
     */
    operator fun get(k: K): V? {
        val index = getIndex(k)
        return array[index][k]
    }

    /**
     * Removes a key-value pair from the associative array.
     * Args:
     *   k: Key of the pair to be removed.
     * Returns:
     *   True if the pair was successfully removed, false otherwise.
     */
    fun remove(k: K): Boolean {
        val index = getIndex(k)
        val map = array[index]
        if (map.containsKey(k)) {
            map.remove(k)
            size--
            return true
        }
        return false
    }

    /**
     * Returns the number of elements stored in the associative array.
     * Returns:
     *   The number of elements stored in the associative array.
     */
    fun size(): Int {
        return size
    }

    /**
     * Returns a list of all key-value pairs in the associative array.
     * Returns:
     *   A list of all key-value pairs in the associative array.
     */
    fun keyValuePairs(): List<Pair<K, V>> {
        return array.flatMap { it.toList() }
    }

    private fun getIndex(key: K): Int {
        val hashCode = key.hashCode()
        val positiveHashCode = hashCode.absoluteValue
        return positiveHashCode % capacity
    }

    private fun resize() {
        capacity *= 2
        val temp = Array<MutableMap<K, V>>(capacity) { mutableMapOf() }

        for (map in array) {
            for ((k, v) in map) {
                val index = getIndex(k)
                temp[index][k] = v
            }
        }
        array = temp
    }
}
