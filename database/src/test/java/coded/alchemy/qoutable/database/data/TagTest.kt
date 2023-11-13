package coded.alchemy.qoutable.database.data

import org.junit.Assert
import org.junit.Test

/**
 * Unit test for the [Tag] class.
 *
 * @author Taji Abdullah
 */
class TagTest {
    @Test
    fun `test tag instantiation`() {
        val tag = Tag(content = "TestTag", quoteId = "fhdhifd")

        Assert.assertNotNull(tag)
        Assert.assertEquals("TestTag", tag.content)
    }
}
