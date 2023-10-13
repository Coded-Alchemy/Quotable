package coded.alchemy.qoutable.database.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import coded.alchemy.qoutable.database.QuotableDatabase
import coded.alchemy.qoutable.database.data.Author
import coded.alchemy.qoutable.database.data.RemoteKey
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Test for the [RemoteKeyDao] interface.
 *
 * @author Taji Abdullah
 */
@RunWith(AndroidJUnit4::class)
class RemoteKeyDaoTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: QuotableDatabase
    private lateinit var remoteKeyDao: RemoteKeyDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            QuotableDatabase::class.java
        ).allowMainThreadQueries().build()
        remoteKeyDao = database.remoteKeyDao()
    }

    @After
    fun cleanup() {
        database.close()
    }

    @Test
    fun testInsertAndReplaceRemoteKey() = runBlocking {
        // Arrange
        val label = "page_1"
        val nextKey = 2
        val remoteKey = RemoteKey(label, nextKey)

        // Act
        remoteKeyDao.insertOrReplace(remoteKey)

        // Assert
        val storedRemoteKey = remoteKeyDao.remoteKeyByQuery(label)
        assertEquals(label, storedRemoteKey.label)
        assertEquals(nextKey, storedRemoteKey.nextKey)
    }

    @Test
    fun testDeleteRemoteKeyByQuery() = runBlocking {
        // Arrange
        val label = "page_1"
        val nextKey = 2
        val remoteKey = RemoteKey(label, nextKey)

        // Act
        remoteKeyDao.insertOrReplace(remoteKey)
        remoteKeyDao.deleteByQuery(label)

        // Assert
        val storedRemoteKey = remoteKeyDao.remoteKeyByQuery(label)
        assertNull(storedRemoteKey)
    }
}