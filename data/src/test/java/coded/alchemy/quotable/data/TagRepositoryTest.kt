package coded.alchemy.quotable.data

import coded.alchemy.qoutable.database.dao.TagDao
import coded.alchemy.qoutable.database.data.Tag
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class TagRepositoryTest {
    private lateinit var repository: TagRepository
    private lateinit var dao: TagDao

    @Before
    fun setup() {
        dao = Mockito.mock(TagDao::class.java)
        repository = TagRepository.getInstance(dao)
    }

    @Test
    fun testInsertTag() = runBlocking {
        // Arrange
        val tag = Tag(1, "Sample Tag")

        // Act
        repository.insertTag(tag)

        // Assert
        Mockito.verify(dao, Mockito.times(1)).insertTag(tag)
    }
}
