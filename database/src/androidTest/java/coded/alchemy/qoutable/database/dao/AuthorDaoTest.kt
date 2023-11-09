package coded.alchemy.qoutable.database.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import coded.alchemy.qoutable.database.QuotableDatabase
import coded.alchemy.qoutable.database.data.Author
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
class AuthorDaoTest {
    private lateinit var database: QuotableDatabase
    private lateinit var authorDao: AuthorDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            QuotableDatabase::class.java
        ).allowMainThreadQueries().build()
        authorDao = database.authorDao()
    }

    @After
    fun cleanup() {
        database.close()
    }

    @Test
    fun testInsertAuthorAndRetrieveById() = runBlocking {
        // Arrange
        val author = Author("John Doe")

        // Act
        authorDao.insertAuthor(author)
        val retrievedAuthor = authorDao.getAuthorByName("John Doe")

        // Assert
        assertNotNull(retrievedAuthor)
        assertEquals(author, retrievedAuthor)
    }
}
