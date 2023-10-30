package coded.alchemy.quotable.data

import coded.alchemy.qoutable.database.dao.QuoteDao
import coded.alchemy.qoutable.database.dao.TagDao
import coded.alchemy.qoutable.database.data.Author
import coded.alchemy.qoutable.database.data.QuoteEntity
import coded.alchemy.qoutable.database.data.Tag
import javax.inject.Inject
import javax.inject.Singleton

/**
 * QuoteRepository.kt
 *
 * This class is for handling data operations.
 *
 * @param quoteDao
 * @author Taji Abdullah
 * */
@Singleton
class QuoteRepository @Inject constructor(private val quoteDao: QuoteDao) {
    /**
     * Insert a [QuoteEntity] into the database.
     * */
    suspend fun insertQuote(quoteEntity: QuoteEntity) = quoteDao.insertQuote(quoteEntity)

    suspend fun getQuotes() = quoteDao.getQuotes()

    companion object {
        // For Singleton instantiation
        @Volatile private var instance: QuoteRepository? = null

        fun getInstance(dao: QuoteDao) =
            instance ?: synchronized(this) {
                instance ?: QuoteRepository(dao).also { instance = it }
            }
    }
}
