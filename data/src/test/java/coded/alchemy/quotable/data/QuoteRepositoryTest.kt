package coded.alchemy.quotable.data

import coded.alchemy.qoutable.database.dao.QuoteDao
import coded.alchemy.qoutable.database.data.Author
import coded.alchemy.qoutable.database.data.QuoteEntity
import coded.alchemy.qoutable.database.data.Tag
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`

/**
 * QuoteRepositoryTest.kt
 *
 * Test for the [QuoteRepository].
 *
 * @author Taji Abdullah
 */
class QuoteRepositoryTest {
    private lateinit var repository: QuoteRepository
    private lateinit var dao: QuoteDao

    @Before
    fun setup() {
        dao = mock(QuoteDao::class.java)
        repository = QuoteRepository(dao)
    }

    @Test
    fun testInsertQuote() = runBlocking {
        // Arrange
        val quoteEntity = QuoteEntity("123", Long.MAX_VALUE, "Sample Quote")

        // Act
        repository.insertQuote(quoteEntity)

        // Assert
        verify(dao, times(1)).insertQuote(quoteEntity)
    }

    @Test
    fun testGetQuotes() = runBlocking {
        // Arrange
        val quotes = listOf(
            QuoteEntity("1", Long.MAX_VALUE, "Quote 1"),
            QuoteEntity("2", 567L, "Quote 2")
        )
        `when`(dao.getQuotes()).thenReturn(quotes)

        // Act
        val result = repository.getQuotes()

        // Assert
        assertNotNull(result)
        assertEquals(quotes, result)
    }

    @Test
    fun testInsertTag() = runBlocking {
        // Arrange
        val tag = Tag(1, "Sample Tag")

        // Act
        repository.insertTag(tag)

        // Assert
        verify(dao, times(1)).insertTag(tag)
    }

    @Test
    fun testInsertAuthor() = runBlocking {
        // Arrange
        val author = Author(1, "John Doe")

        // Act
        repository.insertAuthor(author)

        // Assert
        verify(dao, times(1)).insertAuthor(author)
    }
}
