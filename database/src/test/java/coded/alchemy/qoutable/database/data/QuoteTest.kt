package coded.alchemy.qoutable.database.data

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Unit test for the [Quote] class.
 *
 * @author Taji Abdullah
 */
class QuoteTest {
    @Test
    fun testQuoteProperties() {
        // Arrange
        val id = "123"
        val author = "John Doe"
        val content = "This is a sample quote."
        val tags = listOf("tag1", "tag2")
        val authorSlug = "john-doe"
        val length = 42
        val dateAdded = "2023-01-15"
        val dateModified = "2023-01-20"

        // Act
        val quote = Quote(id, author, content, tags, authorSlug, length, dateAdded, dateModified)

        // Assert
        assertEquals(id, quote._id)
        assertEquals(author, quote.author)
        assertEquals(content, quote.content)
        assertEquals(tags, quote.tags)
        assertEquals(authorSlug, quote.authorSlug)
        assertEquals(length, quote.length)
        assertEquals(dateAdded, quote.dateAdded)
        assertEquals(dateModified, quote.dateModified)
    }
}