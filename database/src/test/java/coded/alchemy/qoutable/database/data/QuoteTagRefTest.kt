package coded.alchemy.qoutable.database.data

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Unit test for the [QuoteTagRef] class.
 *
 * @author Taji Abdullah
 */
class QuoteTagRefTest {
    @Test
    fun testQuoteTagRefProperties() {
        // Arrange
        val quoteId = 1L
        val tagId = 2L

        // Act
        val quoteTagRef = QuoteTagRef(quoteId, tagId)

        // Assert
        assertEquals(quoteId, quoteTagRef.quoteId)
        assertEquals(tagId, quoteTagRef.tagId)
    }
}
