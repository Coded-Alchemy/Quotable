package coded.alchemy.qoutable.database.data

import org.junit.Assert
import org.junit.Test

/**
 * Unit test for the [Author] class.
 *
 * @author Taji Abdullah
 */
class AuthorTest {
    @Test
    fun `test author instantiation`() {
        val author = Author(name = "Test Driven", slug = "test_driven")

        Assert.assertNotNull(author)
        Assert.assertEquals("Test Driven", author.name)
        Assert.assertEquals("test_driven", author.slug)
    }
}
