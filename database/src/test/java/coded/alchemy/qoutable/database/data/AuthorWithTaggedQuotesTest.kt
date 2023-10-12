package coded.alchemy.qoutable.database.data

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class AuthorWithTaggedQuotesTest {
    @Test
    fun testAuthorWithTaggedQuotesProperties() {
        // Arrange
        val author = Author(1, "John Doe")
        val quotes = listOf(
            QuoteWithTags(
                QuoteEntity(quoteId = "101"),
                listOf(Tag(tagId = 201, quoteId = "Tag A"), Tag(tagId = 202, quoteId = "Tag B"))
            ),
            QuoteWithTags(
                QuoteEntity(quoteId = "102", authorId = Long.MAX_VALUE),
                listOf(Tag(tagId = 203, quoteId = "Tag C"))
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