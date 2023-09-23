package coded.alchemy.quotable.data

import coded.alchemy.quotable.data.Quote
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Unit test for the [Quote] class.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class QuoteUnitTest {
    private lateinit var quote1: coded.alchemy.quotable.data.Quote
    private lateinit var quote2: coded.alchemy.quotable.data.Quote
    private lateinit var quote3: coded.alchemy.quotable.data.Quote

    @Before
    fun initTest() {
        quote1 = coded.alchemy.quotable.data.Quote(
            _id = "1",
            author = "Author 1",
            content = "Content 1",
            tags = listOf("Tag1", "Tag2"),
            author_slug = "author1-slug",
            length = 100,
            date_added = "2023-09-21",
            date_modified = "2023-09-21"
        )
        quote2 = coded.alchemy.quotable.data.Quote(
            _id = "2",
            author = "Author 2",
            content = "Content 2",
            tags = listOf("Tag3", "Tag4"),
            author_slug = "author2-slug",
            length = 200,
            date_added = "2023-09-22",
            date_modified = "2023-09-22"
        )
        quote3 = quote1
    }

    @Test
    fun `quote Not Null`() {
        assertNotNull(quote1)
    }

    @Test
    fun `quote contains expected values`() {
        assertEquals("1", quote1._id)
        assertEquals("author1-slug", quote1.author_slug)
    }

    @Test
    fun `quote equality`() {
        assertEquals(quote1, quote3)
        assertEquals(quote3, quote1)
    }

    @Test
    fun `quote inequality`() {
        assertEquals(false, quote1 == quote2)
        assertEquals(false, quote2 == quote3)
    }
}