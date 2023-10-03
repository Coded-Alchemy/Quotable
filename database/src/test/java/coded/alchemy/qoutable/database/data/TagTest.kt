package coded.alchemy.qoutable.database.data

import org.junit.Assert
import org.junit.Test

class TagTest {

    @Test
    fun `test author instantiation`() {
        val tag = Tag(tagId = 56, name = "TestTag")

        Assert.assertNotNull(tag)
        Assert.assertEquals(56, tag.tagId)
        Assert.assertEquals("TestTag", tag.name)
    }
}