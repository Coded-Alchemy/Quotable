package coded.alchemy.qoutable.database.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import coded.alchemy.qoutable.database.QuotableDatabase
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
        val id = 47
        val currentPage = 2
        val lastPage = 56
        val remoteKey = RemoteKey(id = id, currentPage = currentPage, lastPage = lastPage)

        // Act
        remoteKeyDao.insertOrReplace(remoteKey)

        // Assert
        val storedRemoteKey = remoteKeyDao.get()
        assertEquals(id, storedRemoteKey?.id)
        assertEquals(currentPage, storedRemoteKey?.currentPage)
        assertEquals(lastPage, storedRemoteKey?.lastPage)
    }

    @Test
    fun testDeleteRemoteKeyByQuery() = runBlocking {
        // Arrange
        val label = "page_1"
        val nextKey = 2
        val remoteKey = RemoteKey(id = 45, currentPage = 34, lastPage = 89)

        // Act
        remoteKeyDao.insertOrReplace(remoteKey)
        remoteKeyDao.deleteAll()

        // Assert
        val storedRemoteKey = remoteKeyDao.get()
        assertNull(storedRemoteKey)
    }
}
