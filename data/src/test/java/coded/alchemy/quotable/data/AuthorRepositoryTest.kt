package coded.alchemy.quotable.data

import coded.alchemy.qoutable.database.dao.AuthorDao
import coded.alchemy.qoutable.database.data.Author
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

/**
 * QuoteRepositoryTest.kt
 *
 * Test for the [QuoteRepository].
 *
 * @author Taji Abdullah
 */
class AuthorRepositoryTest {
    private lateinit var repository: AuthorRepository
    private lateinit var dao: AuthorDao

    @Before
    fun setup() {
        dao = Mockito.mock(AuthorDao::class.java)
        repository = AuthorRepository.getInstance(dao)
    }

    @Test
    fun testInsertAuthor() = runBlocking {
        // Arrange
        val author = Author("John Doe")

        // Act
        repository.insertAuthor(author)

        // Assert
        Mockito.verify(dao, Mockito.times(1)).insertAuthor(author)
    }
}
