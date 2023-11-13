package coded.alchemy.quotable.data

import coded.alchemy.qoutable.database.dao.QuoteDao
import coded.alchemy.qoutable.database.data.QuoteEntity
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify

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
        repository = QuoteRepository.getInstance(dao)
    }

    @Test
    fun testInsertQuote() = runBlocking {
        // Arrange
        val quoteEntity =
            QuoteEntity("123", "Sample Quote", "slug", "56L", 56L, "modify")

        // Act
        repository.insertQuote(quoteEntity)

        // Assert
        verify(dao, times(1)).insertQuote(quoteEntity)
    }

//    @Test
//    fun testGetQuotes() = runBlocking {
//        // Arrange
//        val quotes = listOf(
//            QuoteEntity("1", Long.MAX_VALUE, "Quote 1"),
//            QuoteEntity("2", 567L, "Quote 2")
//        )
//        `when`(repository.getQuotes()).thenReturn(quotes)
//
//        // Act
//        val result = repository.getQuotes()
//
//        // Assert
//        assertNotNull(result)
//        assertEquals(quotes, result)
//    }
}
