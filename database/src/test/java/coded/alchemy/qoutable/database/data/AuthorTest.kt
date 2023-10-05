package coded.alchemy.qoutable.database.data

import org.junit.Assert
import org.junit.Test

/**
 * Unit test for the [Author] class.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class AuthorTest {
    @Test
    fun `test author instantiation`() {
        val author = Author(authorId = 456, name = "Test Driven", slug = "test_driven")

        Assert.assertNotNull(author)
        Assert.assertEquals(456, author.authorId)
        Assert.assertEquals("Test Driven", author.name)
        Assert.assertEquals("test_driven", author.slug)
    }
}
