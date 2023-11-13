package coded.alchemy.qoutable.database.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import coded.alchemy.qoutable.database.QuotableDatabase
import coded.alchemy.qoutable.database.data.Tag
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * QuoteDaoTest.kt
 *
 * Test for the [QuoteDao] interface.
 *
 * @author Taji Abdullah
 */
@RunWith(AndroidJUnit4::class)
class TagDaoTest {
    private lateinit var database: QuotableDatabase
    private lateinit var tagDao: TagDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            QuotableDatabase::class.java
        ).allowMainThreadQueries().build()
        tagDao = database.tagDao()
    }

    @After
    fun cleanup() {
        database.close()
    }

    @Test
    fun testInsertTagAndRetrieveById() = runBlocking {
        // Arrange
        val tag = Tag("Sample Tag")

        // Act
        tagDao.insertTag(tag)
        val retrievedTag = tagDao.getTagById("Sample Tag")

        // Assert
        assertNotNull(retrievedTag)
        assertEquals(tag, retrievedTag)
    }
}
