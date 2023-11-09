package coded.alchemy.qoutable.database.data

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

/**
 * Unit test for the [AuthorWithTaggedQuotes] class.
 *
 * @author Taji Abdullah
 */
class AuthorWithTaggedQuotesTest {
    @Test
    fun testAuthorWithTaggedQuotesProperties() {
        // Arrange
        val author = Author("John Doe", "John Doe")
        val quotes = listOf(
            QuoteWithTags(
                QuoteEntity(
                    quoteId = "101",
                    author_slug = "slug",
                    content = "content",
                    date_added = "date",
                    date_modified = "moded",
                    length = 56L
                ),
                listOf(Tag(quoteId = "Tag A"), Tag(quoteId = "Tag B"))
            ),
            QuoteWithTags(
                QuoteEntity(
                    quoteId = "156",
                    author_slug = "slug",
                    content = "content",
                    date_added = "date",
                    date_modified = "moded",
                    length = 56L
                ),
                listOf(Tag(quoteId = "Tag C"))
            )
        )

        // Act
        val authorWithTaggedQuotes = AuthorWithTaggedQuotes(author, quotes)

        // Assert
        assertNotNull(authorWithTaggedQuotes)
        assertEquals(author, authorWithTaggedQuotes.author)
        assertEquals(quotes, authorWithTaggedQuotes.quotes)
    }
}
