package coded.alchemy.qoutable.database.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import coded.alchemy.qoutable.database.QuotableDatabase
import coded.alchemy.qoutable.database.data.QuoteEntity
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
        val quoteEntity = QuoteEntity(
            quoteId = "101",
            authorId = 58L,
            author_slug = "slug",
            content = "content",
            date_added = "date",
            date_modified = "moded",
            length = 56L
        )

        // Act
        quoteDao.insertQuote(quoteEntity)
        val retrievedQuote = quoteDao.getQuoteById("101")

        // Assert
        assertNotNull(retrievedQuote)
        assertEquals(quoteEntity, retrievedQuote)
    }

    @Test
    fun testGetAllQuotes() = runBlocking {
        // Arrange
        val quote1 = QuoteEntity(
            quoteId = "101",
            authorId = 58L,
            author_slug = "slug",
            content = "content",
            date_added = "date",
            date_modified = "moded",
            length = 56L
        )
        val quote2 = QuoteEntity(
            quoteId = "102",
            authorId = 58L,
            author_slug = "slug",
            content = "content",
            date_added = "date",
            date_modified = "moded",
            length = 56L
        )

        // Act
        quoteDao.insertQuote(quote1, quote2)
        val quotes = quoteDao.getQuotes()

        // Assert
        assertEquals(2, quotes.size)
        assertEquals(quote1, quotes[0])
        assertEquals(quote2, quotes[1])
    }
}
