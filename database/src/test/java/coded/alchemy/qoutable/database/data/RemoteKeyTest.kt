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
        val id = 67
        val currentPage = 2
        val lastPage = 56

        // Act
        val remoteKey = RemoteKey(id = id, currentPage = currentPage, lastPage = lastPage)

        // Assert
        assertEquals(id, remoteKey.id)
        assertEquals(currentPage, remoteKey.currentPage)
        assertEquals(lastPage, remoteKey.lastPage)
    }
}
