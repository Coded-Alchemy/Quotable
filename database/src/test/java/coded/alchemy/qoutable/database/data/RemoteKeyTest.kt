package coded.alchemy.qoutable.database.data

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Unit test for the [RemoteKey] class.
 *
 * @author Taji Abdullah
 */
class RemoteKeyTest {
    @Test
    fun testRemoteKeyProperties() {
        // Arrange
        val label = "page_1"
        val nextKey = 2

        // Act
        val remoteKey = RemoteKey(label, nextKey)

        // Assert
        assertEquals(label, remoteKey.label)
        assertEquals(nextKey, remoteKey.nextKey)
    }
}
