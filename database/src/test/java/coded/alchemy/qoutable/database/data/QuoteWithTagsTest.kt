package coded.alchemy.qoutable.database.data

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Unit test for the [QuoteWithTags] class.
 *
 * @author Taji Abdullah
 */
class QuoteWithTagsTest {
    @Test
    fun testQuoteWithTagsProperties() {
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
        val tags = listOf(
            Tag(tagId = 101, quoteId = "Tag A"),
            Tag(tagId = 102, quoteId = "Tag B")
        )

        // Act
        val quoteWithTags = QuoteWithTags(quoteEntity, tags)

        // Assert
        assertEquals(quoteEntity, quoteWithTags.quoteEntity)
        assertEquals(tags, quoteWithTags.tags)
    }
}
