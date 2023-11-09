package coded.alchemy.qoutable.database.data

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

/**
 * Unit test for the [QuoteEntity] class.
 *
 * @author Taji Abdullah
 */
class QuoteEntityUnitTest {
    private lateinit var quoteEntity1: QuoteEntity
    private lateinit var quoteEntity2: QuoteEntity
    private lateinit var quoteEntity3: QuoteEntity

    @Before
    fun initTest() {
        quoteEntity1 =
            QuoteEntity(
                quoteId = "1",
                content = "Content 1",
                author_slug = "author1-slug",
                length = 100,
                date_added = "2023-09-21",
                date_modified = "2023-09-21"
            )
        quoteEntity2 =
            QuoteEntity(
                quoteId = "2",
                content = "Content 2",
                author_slug = "author2-slug",
                length = 200,
                date_added = "2023-09-22",
                date_modified = "2023-09-22"
            )
        quoteEntity3 = quoteEntity1
    }

    @Test
    fun `quote Not Null`() {
        assertNotNull(quoteEntity1)
    }

    @Test
    fun `quote contains expected values`() {
        assertEquals("1", quoteEntity1.quoteId)
        assertEquals("author1-slug", quoteEntity1.author_slug)
    }

    @Test
    fun `quote equality`() {
        assertEquals(quoteEntity1, quoteEntity3)
        assertEquals(quoteEntity3, quoteEntity1)
    }

    @Test
    fun `quote inequality`() {
        assertEquals(false, quoteEntity1 == quoteEntity2)
        assertEquals(false, quoteEntity2 == quoteEntity3)
    }
}
