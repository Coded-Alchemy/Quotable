package coded.alchemy.quotable.data

import coded.alchemy.qoutable.database.dao.AuthorDao
import coded.alchemy.qoutable.database.data.Author
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

    /**
     * Insert a [Author] into the database.
     * */
    suspend fun insertAuthor(author: Author) = authorDao.insertAuthor(author)

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