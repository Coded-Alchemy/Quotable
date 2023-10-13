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
        val tag = Tag(tagId = 56L, content = "TestTag", quoteId = "fhdhifd")

        Assert.assertNotNull(tag)
        Assert.assertEquals(56L, tag.tagId)
        Assert.assertEquals("TestTag", tag.content)
    }
}
