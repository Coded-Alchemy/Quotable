package coded.alchemy.quotable.data

import coded.alchemy.qoutable.database.dao.QuoteDao
import coded.alchemy.qoutable.database.data.Quote
import coded.alchemy.qoutable.database.data.Tag

/**
 * QuoteRepository.kt
 *
 * This class is for handling data operations.
 *
 * @param dao
 * @author Taji Abdullah
 * */
class QuoteRepository(private val dao: QuoteDao) {

    /**
     * Insert a [Quote] into the database.
     * */
    suspend fun insertQuote(quote: Quote) = dao.insertQuote(quote)

    /**
     * Insert a [Tag] into the database.
     * */
    suspend fun insertTag(tag: Tag) = dao.insertTag(tag)

    companion object {
        // For Singleton instantiation
        @Volatile private var instance: QuoteRepository? = null

        fun getInstance(dao: QuoteDao) =
            instance ?: synchronized(this) {
                instance ?: QuoteRepository(dao).also { instance = it }
            }
    }
}