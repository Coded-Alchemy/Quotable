package coded.alchemy.quotable.data

import coded.alchemy.qoutable.database.dao.AuthorDao
import coded.alchemy.qoutable.database.data.Author
import coded.alchemy.qoutable.database.data.QuoteEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * AuthorRepository.kt
 *
 * This class is for handling data operations for [Author].
 *
 * @param authorDao
 * @author Taji Abdullah
 * */
@Singleton
class AuthorRepository @Inject constructor(private val authorDao: AuthorDao) {
    private val TAG = this.javaClass.simpleName

    /**
     * Insert a [Author] into the database.
     * */
    suspend fun insertAuthor(author: Author) {
        authorDao.insertAuthor(author)
    }

    fun getAllAuthors(): Flow<List<Author>> {
        return authorDao.getAllAuthors()
    }

    fun getAuthorWithQuotes(authorName: String): Map<Author, List<QuoteEntity>> {
        return authorDao.getAuthorWithQuotes(authorName)
    }

    companion object {
        // For Singleton instantiation
        @Volatile
        private var instance: AuthorRepository? = null

        fun getInstance(authorDao: AuthorDao) =
            instance ?: synchronized(this) {
                instance ?: AuthorRepository(authorDao).also { dao -> instance = dao }
            }
    }
}
