package coded.alchemy.qoutable.database.data

import org.junit.Assert
import org.junit.Test

class TagTest {
    @Test
    fun `test tag instantiation`() {
        val tag = Tag(tagId = 56L, content = "TestTag", quoteId = "fhdhifd")

        Assert.assertNotNull(tag)
        Assert.assertEquals(56L, tag.tagId)
        Assert.assertEquals("TestTag", tag.content)
    }
}
