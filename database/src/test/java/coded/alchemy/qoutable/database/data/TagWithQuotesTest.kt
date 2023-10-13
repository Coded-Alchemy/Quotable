package coded.alchemy.qoutable.database.data

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Unit test for the [TagWithQuotes] class.
 *
 * @author Taji Abdullah
 */
class TagWithQuotesTest {
    @Test
    fun testTagWithQuotesProperties() {
        // Arrange
        val tag = Tag()
        val quoteEntities = listOf(
            QuoteEntity("101"),
            QuoteEntity("102")
        )

        // Act
        val tagWithQuotes = TagWithQuotes(tag, quoteEntities)

        // Assert
        assertEquals(tag, tagWithQuotes.tag)
        assertEquals(quoteEntities, tagWithQuotes.quoteEntities)
    }
}