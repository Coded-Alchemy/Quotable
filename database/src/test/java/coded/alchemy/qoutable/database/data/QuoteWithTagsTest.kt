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
        val quoteEntity = QuoteEntity(quoteId = "dkjfdkjf", authorId = Long.MAX_VALUE)
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
