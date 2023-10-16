package coded.alchemy.qoutable.database.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import coded.alchemy.qoutable.database.QuotableDatabase
import coded.alchemy.qoutable.database.data.Author
import coded.alchemy.qoutable.database.data.QuoteEntity
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
class QuoteDaoTest {
    private lateinit var database: QuotableDatabase
    private lateinit var quoteDao: QuoteDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            QuotableDatabase::class.java
        ).allowMainThreadQueries().build()
        quoteDao = database.quoteDao()
    }

    @After
    fun cleanup() {
        database.close()
    }

    @Test
    fun testInsertQuoteAndRetrieveById() = runBlocking {
        // Arrange
        val quoteEntity = QuoteEntity("123", Long.MAX_VALUE, "Sample Quote")

        // Act
        quoteDao.insertQuote(quoteEntity)
        val retrievedQuote = quoteDao.getQuoteById("123")

        // Assert
        assertNotNull(retrievedQuote)
        assertEquals(quoteEntity, retrievedQuote)
    }

    @Test
    fun testInsertTagAndRetrieveById() = runBlocking {
        // Arrange
        val tag = Tag(1, "Sample Tag")

        // Act
        quoteDao.insertTag(tag)
        val retrievedTag = quoteDao.getTagById(1)

        // Assert
        assertNotNull(retrievedTag)
        assertEquals(tag, retrievedTag)
    }

    @Test
    fun testInsertAuthorAndRetrieveById() = runBlocking {
        // Arrange
        val author = Author(1, "John Doe")

        // Act
        quoteDao.insertAuthor(author)
        val retrievedAuthor = quoteDao.getAuthorById(1)

        // Assert
        assertNotNull(retrievedAuthor)
        assertEquals(author, retrievedAuthor)
    }

    @Test
    fun testGetAllQuotes() = runBlocking {
        // Arrange
        val quote1 = QuoteEntity("1", Long.MAX_VALUE, "Quote 1")
        val quote2 = QuoteEntity("2", content = "blah blah blah")

        // Act
        quoteDao.insertQuote(quote1, quote2)
        val quotes = quoteDao.getQuotes()

        // Assert
        assertEquals(2, quotes.size)
        assertEquals(quote1, quotes[0])
        assertEquals(quote2, quotes[1])
    }
}
