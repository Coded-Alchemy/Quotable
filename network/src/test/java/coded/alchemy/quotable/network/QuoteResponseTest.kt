package coded.alchemy.quotable.network

import coded.alchemy.qoutable.database.data.Quote
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * QuoteResponseTest.kt
 *
 * Test class for [QuoteResponse].
 *
 * @author Taji Abdullah
 * */
class QuoteResponseTest {
    @Test
    fun testQuoteResponseProperties() {
        // Arrange
        val count = 10
        val totalCount = 100
        val page = 1
        val totalPages = 5
        val lastItemIndex = 9
        val quotes = listOf(
            Quote("1", "100L"),
            Quote("2", "200L"),
            Quote("3", "300L")
        )

        // Act
        val quoteResponse = QuoteResponse(count, totalCount, page, totalPages, lastItemIndex, quotes)

        // Assert
        assertEquals(count, quoteResponse.count)
        assertEquals(totalCount, quoteResponse.totalCount)
        assertEquals(page, quoteResponse.page)
        assertEquals(totalPages, quoteResponse.totalPages)
        assertEquals(lastItemIndex, quoteResponse.lastItemIndex)
        assertEquals(quotes, quoteResponse.results)
    }
}
