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
            QuoteEntity(
                quoteId = "101",
                author_slug = "slug",
                content = "content",
                date_added = "date",
                date_modified = "moded",
                length = 56L
            ),
            QuoteEntity(
                quoteId = "105",
                author_slug = "slug",
                content = "content",
                date_added = "date",
                date_modified = "moded",
                length = 56L
            )
        )

        // Act
        val tagWithQuotes = TagWithQuotes(tag, quoteEntities)

        // Assert
        assertEquals(tag, tagWithQuotes.tag)
        assertEquals(quoteEntities, tagWithQuotes.quoteEntities)
    }
}
